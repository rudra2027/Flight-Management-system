package Admin.pojo;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import nonapi.io.github.classgraph.json.Id;



@Document(collection = "Trains")
public class Flight {
@Id
private int id;
private String departure_location;
private String arrival_location;
private  List<FlightData> flight;

public Flight() {}


public Flight(int id, String departure_location, String arrival_location,
		List<FlightData> flight) {
	super();
	this.id = id;
	this.departure_location = departure_location;
	this.arrival_location = arrival_location;
	this.flight = flight;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDeparture_location() {
	return departure_location;
}
public void setDeparture_location(String departure_location) {
	this.departure_location = departure_location;
}
public String getArrival_location() {
	return arrival_location;
}
public void setArrival_location(String arrival_location) {
	this.arrival_location = arrival_location;
}

public List<FlightData> getFlight() {
	return flight;
}
public void setFlight(List<FlightData> flight) {
	this.flight = flight;
}


}
