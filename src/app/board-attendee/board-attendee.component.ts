import { Time } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookingModel } from '../models/booking-model.model';
import { Checkin } from '../models/checkin.model';
import { FlightModel } from '../models/flight-model.model';
import { Flight } from '../models/flight.model';
import { CheckinService } from '../_service/checkin.service';
import { TokenStorageService } from '../_service/token-storage.service';

/* interface Booking {
  booking_id: Number;
  departure_date: Date;
  booking_date: Date;
  flight: Array<{flight_id:Number,departure_time:Time,arrival_time:Time}>;
  passenger:Array<{passenger_id:Number,passenger_name:String,passenger_age:Number,passenger_seat:Number}>;
} */
@Component({
  selector: 'app-board-attendee',
  templateUrl: './board-attendee.component.html',
  styleUrls: ['./board-attendee.component.css']
})
export class BoardAttendeeComponent implements OnInit {
  
Checkin:Checkin[]=[];
isLoggedIn=false;
usermail:any;
  isVisible: any;
  isSelected: boolean = true;
  checkedIn=false;
  data:any;
  res:any[]=[];

    form1:any={
    booking_id:null
  }
  form2:any={
    booking_id:null
  }
  result:any;
  message2="";
  message = '';
  constructor(private CheckIn:CheckinService,private Http:HttpClient,private tokenStorageService:TokenStorageService) { }

  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorageService.getToken();
    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.usermail = user.email;
    }
  }
 getTicket(): void {
   const{booking_id}=this.form1;
  this.CheckIn.GetTicket(booking_id).subscribe(data=>{
    this.res.push(data);
  console.log(data);
  return this.data;});
  console.log(this.res);

} 
Checkedin():void{
  const{booking_id}=this.form2;
  this.CheckIn.CheckIn(booking_id,this.usermail).subscribe(data=>console.log(data));
  this.checkedIn=true;
  this.message="Checked-In Successfully! Enjoy Your Journey";
}

 
}
