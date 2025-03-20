import { AfterViewInit, Component, ElementRef, Input, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { MessageService } from './message.service';
import { Message } from './message.interface';
import { User } from '../user/user.interface';
import { environment } from '../../environments/environment';
import { Client } from '@stomp/stompjs';

@Component({
    selector: 'app-messages',
    templateUrl: './messages.component.html',
    styleUrls: ['./messages.component.scss'],
    standalone: false
})
export class MessagesComponent implements OnInit, OnDestroy, AfterViewInit {
  @Input() user: User;

  @ViewChild('messageInput') messageInput: ElementRef;

  messages: Message[] = [];
  messageControl = new FormControl<string>('', { nonNullable: true });
  websocketClient: Client;
  private roomId: string;

  constructor(
    private messageService: MessageService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.roomId = this.route.snapshot.paramMap.get('roomId');
    if (!this.roomId) {
      console.error('No room ID provided');
      return;
    }

    this.messageService.getMessagesByRoomId(this.roomId)
      .then((messages: Message[]) => {
        this.messages = messages.map(msg => ({
          ...msg,
          date: new Date(msg.date)
        }));
      })
      .catch(error => console.error('Error loading messages:', error));

    this.connect();
  }

  ngAfterViewInit(): void {
    setTimeout(() => this.messageInput?.nativeElement.focus(), 0);
  }

  ngOnDestroy(): void {
    this.disconnect();
  }

  private connect(): void {
    if (!this.roomId) return;

    this.websocketClient = new Client({
      brokerURL: environment.webSocket,
      reconnectDelay: 5000,
      heartbeatIncoming: 4000,
      heartbeatOutgoing: 4000,
      onConnect: () => {
        this.websocketClient.subscribe(`/chat/${this.roomId}`, (frame) => {
          const message: Message = JSON.parse(frame.body);
          this.messages.push({
            id: message.id,
            text: message.text,
            userId: message.userId,
            userName: message.userName,
            roomId: message.roomId,
            date: new Date(message.date)
          });
        });
      },
      onStompError: (frame) => {
        console.error('WebSocket error:', frame);
      }
    });
    this.websocketClient.activate();
  }

  private disconnect(): void {
    this.websocketClient?.deactivate()
      .then(() => console.log(`Disconnected from room ${this.roomId}`))
      .catch(error => console.error('Disconnect error:', error));
  }

  send(): void {
    const text = this.messageControl.value.trim();
    if (!text || !this.roomId || !this.user) return;

    const message: Message = {
      id: '', // Will be set by backend
      text,
      userId: this.user.id,
      userName: this.user.name || 'Anonymous', // Assuming User has a name property
      roomId: this.roomId,
      date: new Date()
    };

    this.messageService.send(message)
      .then(() => this.messageControl.reset())
      .catch(error => console.error('Send message error:', error));
  }

  isToday(date: Date): boolean {
    const today = new Date();
    return date.getDate() === today.getDate() &&
      date.getMonth() === today.getMonth() &&
      date.getFullYear() === today.getFullYear();
  }

  isCurrentUser(userId: string): boolean {
    return userId === this.user?.id;
  }
}
