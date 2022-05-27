import { Component, OnInit } from '@angular/core';
import { Route, Router, Routes } from '@angular/router';
import { AuthService } from '../_service/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  form: any = {
    username: null,
    email: null,
    password: null
  };
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  constructor(private authService: AuthService,private router:Router ) { }
  ngOnInit(): void {
  }
  onSubmit(): void {
    const { username, email, password } = this.form;
    this.authService.register(username, email, password).subscribe(
      data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
       this.router.navigate(['/login'])
      },
      err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    );
  }
}
