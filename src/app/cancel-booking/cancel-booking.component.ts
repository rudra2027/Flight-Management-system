import { Component, OnInit } from '@angular/core';
import { Cancel } from '../models/cancel.model';
import { CancelBookingService } from '../_service/cancel-booking.service';
import { TokenStorageService } from '../_service/token-storage.service';

@Component({
  selector: 'app-cancel-booking',
  templateUrl: './cancel-booking.component.html',
  styleUrls: ['./cancel-booking.component.css']
})
export class CancelBookingComponent implements OnInit {
  isLoggedIn=false;
usermail:any;
  form:any={
    booking_id:null,
  }
  msg=new Cancel(true);
  
  
  data:any;
  booking_cancelled=false;
  constructor(private tokenStorageService:TokenStorageService,private cancelBooking:CancelBookingService) { }

  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorageService.getToken();
    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.usermail = user.email;
    }
  }

  onSubmit():void{
    console.log(this.form.booking_id);
    const{booking_id}=this.form;
    console.log(this.msg);
    this.cancelBooking.cancelBooking(booking_id,this.usermail,this.msg).subscribe(data=>{
      this.booking_cancelled=true
   return this.data;});
  }
  clickAlert(){
    alert("Confirm Cancellation!");
  }
 
}
