import {Component, Input, OnInit} from '@angular/core';
import {User} from '../user/user.interface';
import {Room} from './room'; // Assuming this is your Room interface file
import {RoomService} from './room.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-rooms',
  templateUrl: './rooms.component.html',
  styleUrls: ['./rooms.component.scss']
})
export class RoomsComponent implements OnInit {
  @Input() user: User;

  rooms: Room[] = [];
  isLoading: boolean = false; // Optional: for loading state

  constructor(
    private roomService: RoomService,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    console.log('User:', this.user);
    this.getRooms();
  }

  getRooms(): void {
    this.isLoading = true; // Start loading
    this.roomService.getRooms()
      .then((rooms: Room[]) => {
        this.rooms = rooms.map(room => ({
          ...room,
          ROOM_CAPACITY: 5 // Set default capacity if not provided by backend
        }));
      })
      .catch(error => {
        console.error('Error fetching rooms:', error);
        alert('Failed to load rooms. Please try again later.');
      })
      .finally(() => {
        this.isLoading = false; // End loading
      });
  }

  createRoom(): void {
    if (!this.user?.id) {
      console.error('No user ID available');
      alert('Please log in to create a room.');
      return;
    }

    this.isLoading = true;
    this.roomService.create(this.user.id, 'New Room')
      .then(() => {
        this.getRooms(); // Refresh room list
      })
      .catch(error => {
        console.error('Error creating room:', error);
        alert('Failed to create room. Please try again.');
      })
      .finally(() => {
        this.isLoading = false;
      });
  }

  enterRoom(roomId: string): void {
    if (!this.user?.id) return;
    this.isLoading = true;
    this.roomService.enterRoom(this.user.id, roomId).subscribe({
      next: () => this.router.navigate(['/messages', roomId]),
      error: (error) => {
        console.error(`Failed to enter room ${roomId}:`, error);
        alert('Unable to join the room.');
      },
      complete: () => this.isLoading = false
    });
  }
}
