import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DateTime } from 'luxon';
import { BookingModel } from '../models/booking-model.model';
import { FlightModel } from '../models/flight-model.model';
import { PassengerModel } from '../models/passenger-model.model';
import { BookingService } from '../_service/booking.service';
import { TokenStorageService } from '../_service/token-storage.service';
@Component({
  selector: 'app-board-user',
  templateUrl: './board-user.component.html',
  styleUrls: ['./board-user.component.css']
})  

export class BoardUserComponent implements OnInit {

 isLoggedIn=false;
 usermail:any;
  LocalDate=new Date();
  dep_date?:any;
  flight_id?:any;
  pas_id=Math.floor(new Date().valueOf() /125678035 *400 );
  flight=new FlightModel(this.flight_id);
  passenger=new PassengerModel(this.pas_id,"",0,0,0)
  booking=new BookingModel(new Date().getUTCMilliseconds(),this.dep_date,this.LocalDate,this.flight,[this.passenger],0);
  submitted = false;
  username:any;
  message="";

  constructor(private bookingService:BookingService,private route:ActivatedRoute ,private tokenStorageService:TokenStorageService,private router:Router) { }

  ngOnInit(): void {
 if(this.passenger.passenger_seat<=30){this.passenger.amount=6320}
   

    this.route.paramMap.subscribe((params)=>{this.dep_date=params.get('date')!});
    console.log(this.dep_date);
    this.route.paramMap.subscribe((params)=>{this.flight_id=+params.get('flight_id')!});
    console.log(this.flight_id);
        this.booking.departure_date=this.dep_date;
        console.log(this.booking.departure_date);
           this.flight.flight_id=this.flight_id;
           console.log(this.flight.flight_id);

           this.isLoggedIn = !!this.tokenStorageService.getToken();
    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.usermail = user.email;
      this.username=user.username;
    }
    
    
    
  }
  saveBooking(): void {
    if(this.passenger.passenger_seat>30){this.passenger.amount=8320}

    const data={
      booking_id:this.booking.booking_id,
      departure_date:this.booking.departure_date,
      booking_date:this.booking.booking_date,
      flight:this.booking.flight,
      passenger:this.booking.passenger,
      otp:this.booking.otp
    }
    this.router.navigate(['/payment/',this.username,this.passenger.amount])
    this.bookingService.create(data,this.usermail)
      .subscribe({
        next: (res) => {
          console.log(res.status);
          this.submitted = true;
          
        },
        error: (e) => console.error(e)
      });
    this.message="Booking Made successfully with PNR - "+this.booking.booking_id+" & "+"Passenger details: "+this.passenger.passenger_name+" / seat:"+this.passenger.passenger_seat;
    console.log(this.message);

      
  }
  newPassenger(){
    this.submitted = false;
 this.booking.passenger.push(new PassengerModel(this.pas_id,"",0,0,0))
  console.log(this.booking.passenger);
  console.log(this.passenger.passenger_seat);
  console.log(this.passenger.amount);
  }

 
  

}


