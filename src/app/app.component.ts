import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { TokenStorageService } from './_service/token-storage.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  private roles: string[] = [];
  isLoggedIn = false;
  showAdminBoard = false;
  showAttendeeBoard = false;
  username?: string;

 constructor(private tokenStorageService: TokenStorageService ,private router:Router ) { }
  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorageService.getToken();
    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;
      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      this.showAttendeeBoard = this.roles.includes('ROLE_ATTENDEE');
      this.username = user.username;
    }
  }
  logout(): void {
    this.tokenStorageService.signOut();
    this.router.navigate(["/home"])
    window.location.reload();
  }
}
