package FlightSearch.pojo;

public class Seats {
private String status;
private int capacity;
private int rate;
public Seats() {}

public Seats(String status, int capacity, int rate) {
	super();
	status = status;
	this.capacity = capacity;
	this.rate = rate;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	status = status;
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
