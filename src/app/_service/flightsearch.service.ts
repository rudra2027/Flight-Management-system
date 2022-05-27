import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Flight } from '../models/flight.model';

@Injectable({
  providedIn: 'root'
})
export class FlightSearchService {
  FlightSearchApi = 'http://localhost:8081/Search/find/';
  
  constructor(private Http:HttpClient) { }

  GetFlights(departure_location:any,arrival_location:any):Observable<Flight[]>{
    return this.Http.get<Flight[]>(this.FlightSearchApi+ departure_location +"/" +arrival_location);
  }
}
