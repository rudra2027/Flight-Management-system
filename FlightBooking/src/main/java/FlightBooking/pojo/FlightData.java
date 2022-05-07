package FlightBooking.pojo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="flightData")
public class FlightData {
@Id
private int flight_id;	
private int flight_number;
private String departure_time;
private String arrival_time;

/* private List<Seats>seats; */
public FlightData() {}


public FlightData(int flight_id,int flight_number, String departure_time, String arrival_time) {
	super();
	this.flight_id=flight_id;
	this.flight_number = flight_number;
	this.departure_time = departure_time;
	this.arrival_time = arrival_time;
	
	/* this.seats=seats; */
}


public int getFlight_id() {
	return flight_id;
}


public void setFlight_id(int flight_id) {
	this.flight_id = flight_id;
}


public int getFlight_number() {
	return flight_number;
}
public void setFlight_number(int flight_number) {
	this.flight_number = flight_number;
}
public String getDeparture_time() {
	return departure_time;
}
public void setDeparture_time(String departure_time) {
	this.departure_time = departure_time;
}
public String getArrival_time() {
	return arrival_time;
}
public void setArrival_time(String arrival_time) {
	this.arrival_time = arrival_time;
}





/*
 * public List<Seats> getSeats() { return seats; }
 * 
 * 
 * public void setSeats(List<Seats> seats) { this.seats = seats; }
 */



}
