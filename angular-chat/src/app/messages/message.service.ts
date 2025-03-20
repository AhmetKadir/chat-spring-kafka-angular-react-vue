import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Message } from './message.interface';
import { map } from 'rxjs/operators';
import { environment } from '../../environments/environment';
import { lastValueFrom } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MessageService {
  private server = environment.server;

  constructor(private http: HttpClient) {}

  // Get all messages (might not be needed anymore with room-based system)
  getMessages(): Promise<Message[]> {
    return lastValueFrom(
      this.http.get<Message[]>(`${this.server}/messages`).pipe(
        map((messages: Message[]) =>
          messages.map(message => ({
            ...message,
            date: new Date(message.date)
          }))
        )
      )
    );
  }

  // Get messages for a specific room
  getMessagesByRoomId(roomId: string): Promise<Message[]> {
    return lastValueFrom(
      this.http.get<Message[]>(`${this.server}/messages/room/${roomId}`).pipe(
        map((messages: Message[]) =>
          messages.map(message => ({
            ...message,
            date: new Date(message.date)
          }))
        )
      )
    );
  }

  // Send a message with full Message interface
  send(message: Message): Promise<Message> {
    return lastValueFrom(
      this.http.post<Message>(`${this.server}/messages/new`, message)
    );
  }
}
