import { DateTime } from "luxon";
import { FlightModel } from "./flight-model.model";

export class BookingModel {
   constructor(
   public booking_id:number,
   public departure_date:Date,
   public booking_date:Date,
   public flight:FlightModel, 
   public passenger:Array<{ passenger_id:Number,passenger_name:String,passenger_age:Number,passenger_seat:Number,amount:Number}>,
   public otp:number)
    {}
}
