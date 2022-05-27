import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Checkin } from '../models/checkin.model';


@Injectable({
  providedIn: 'root'
})
export class CheckinService {
 CheckInApi = 'http://localhost:8084/attendee/';
  constructor(private Http:HttpClient) { }

  GetTicket(booking_id:any){
    return this.Http.get(this.CheckInApi+"BookedFlight/"+booking_id);
  }
  CheckIn(booking_id:any,mailId:any,body?:boolean){
    return this.Http.put(this.CheckInApi+"booking/"+booking_id+"/"+mailId,body);
  }
}
