package ChekIn.pojo;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection="booking")

public class Booking {
@Id
public long booking_id;

public Date departure_date;
public LocalDate booking_date;
@DBRef
public FlightData flight;
public List<Passenger>passenger=new ArrayList<>();
public double total_amount;
public int otp;
@Field
public boolean booking_cancelled= false;
public boolean checked_in= false;
public String payment_completed;

public Booking() {}




public Booking(long booking_id, Date departure_date, LocalDate booking_date, FlightData flight,
		List<Passenger> passenger, int otp, boolean booking_cancelled, boolean checked_in,double total_amount,String payment_completed) {
	super();
	this.booking_id=booking_id;
	this.departure_date = departure_date;
	this.booking_date = booking_date;
	this.flight = flight;
	this.passenger = passenger;
	this.otp = otp;
	this.booking_cancelled = booking_cancelled;
	this.checked_in = checked_in;
	this.total_amount=total_amount;
	this.payment_completed=payment_completed;
}


public long getBooking_id() {
	return booking_id;
}

public void setBooking_id(long booking_id) {
	this.booking_id = booking_id;
}


public Date getDeparture_date() {
	return departure_date;
}
public void setDeparture_date(Date departure_date) {
	this.departure_date = departure_date;
}
public LocalDate getBooking_date() {
	return booking_date;
}
public void setBooking_date(LocalDate booking_date) {
	this.booking_date = booking_date;
}
public FlightData getFlight() {
	return flight;
}
public void setFlight(FlightData flight) {
	this.flight = flight;
}
public List<Passenger> getPassenger() {
	return passenger;
}
public void setPassenger(List<Passenger> passenger) {
	this.passenger = passenger;
}
public int getOtp() {
	return otp;
}
public void setOtp(int otp) {
	this.otp = otp;
}
public boolean isBooking_cancelled() {
	return booking_cancelled;
}
public void setBooking_cancelled(boolean booking_cancelled) {
	this.booking_cancelled = booking_cancelled;
}
public boolean isChecked_in() {
	return checked_in;
	
}
public void setChecked_in(boolean checked_in) {
	this.checked_in = checked_in;
}


public double getTotal_amount() {
	return total_amount;
}




public void setTotal_amount(double total_amount) {
	this.total_amount = total_amount;
}




public String isPayment_completed() {
	return payment_completed;
}




public void setPayment_completed(String payment_completed) {
	this.payment_completed = payment_completed;
}










}
