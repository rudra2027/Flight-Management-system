import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
const baseUrl = 'http://localhost:8082/FlightBooking/booking/';
@Injectable({
  providedIn: 'root'
})
export class CancelBookingService {

  constructor(private http:HttpClient) { }
  cancelBooking(booking_id:any,mailId:any,data:any){
    return this.http.put(baseUrl+booking_id+"/"+mailId, data);
  }
}
