package FlightBooking.pojo;

public class Seats {
private int seat_id;
private String status;
private int capacity;
private int rate;
public Seats() {}

public Seats(int seat_id,String status, int capacity, int rate) {
	super();
	this.seat_id=seat_id;
	this.status = status;
	this.capacity = capacity;
	this.rate = rate;
}


public int getSeat_id() {
	return seat_id;
}

public void setSeat_id(int seat_id) {
	this.seat_id = seat_id;
}

public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public int getCapacity() {
	return capacity;
}
public void setCapacity(int capacity) {
	this.capacity = capacity;
}
public int getRate() {
	return rate;
}
public void setRate(int rate) {
	this.rate = rate;
}

	
}
