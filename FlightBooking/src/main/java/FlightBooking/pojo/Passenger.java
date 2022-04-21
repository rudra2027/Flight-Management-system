package FlightBooking.pojo;

import javax.annotation.processing.Generated;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="passengers")
public class Passenger {
@Id
public int passenger_id;
public String passenger_name;
public int passenger_age;
public int passenger_seat;


public Passenger() {}

public Passenger(int passenger_id, String passenger_name, int passenger_age, int passenger_seat) {
	super();
	this.passenger_id = passenger_id;
	this.passenger_name = passenger_name;
	this.passenger_age = passenger_age;
	this.passenger_seat = passenger_seat;
}


public int getPassenger_id() {
	return passenger_id;
}


public void setPassenger_id(int passenger_id) {
	this.passenger_id = passenger_id;
}


public String getPassenger_name() {
	return passenger_name;
}


public void setPassenger_name(String passenger_name) {
	this.passenger_name = passenger_name;
}


public int getPassenger_age() {
	return passenger_age;
}


public void setPassenger_age(int passenger_age) {
	this.passenger_age = passenger_age;
}


public int getPassenger_seat() {
	return passenger_seat;
}


public void setPassenger_seat(int passenger_seat) {
	this.passenger_seat = passenger_seat;
}


}
