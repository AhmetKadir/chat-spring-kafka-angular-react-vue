import {Component, ElementRef, ViewChild} from '@angular/core';
import {FormControl} from "@angular/forms";
import {User} from "../user/user.interface";
import {UserService} from "../user/user.service";
import {Router} from "@angular/router";

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss'],
    standalone: false
})
export class LoginComponent {
  @ViewChild('userInput') userInput: ElementRef;

  userName = new FormControl<string>('', { nonNullable: true });
  user: User | null = null;
  isLoading = false; // Optional: for UX feedback

  constructor(
    private userService: UserService,
    private router: Router
  ) {}

  ngAfterViewInit(): void {
    setTimeout(() => this.userInput?.nativeElement.focus(), 0);
  }

  activateUser(): void {
    const name = this.userName.value.trim();
    if (!name) return; // Skip if empty or whitespace

    this.isLoading = true;
    this.userService.getUser(name).subscribe({
      next: (user) => {
        this.user = user;
        console.log('User activated:', this.user);
        this.router.navigate(['/rooms'])
          .then(success => {console.log('Navigation success:', success);})
          .catch(err => console.error('Navigation error:', err));
      },
      error: (error) => {
        console.error('Error activating user:', error);
        alert('Failed to activate user. Please try again.');
        this.isLoading = false;
      },
      complete: () => {
        this.isLoading = false;
      }
    });
  }
}
