import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
const baseUrl = 'http://localhost:8082/FlightBooking/BookFlight/';
@Injectable({
  providedIn: 'root'
})
export class BookingService {

  constructor(private http:HttpClient) { }
  create(data:any,Id:any): Observable<any> {
    return this.http.post(baseUrl+Id, data);
  }
}
