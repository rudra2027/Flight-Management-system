package FlightBooking.pojo;


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

import lombok.Getter;
import lombok.Setter;

@Document(collection="booking")
@Getter
@Setter
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
public boolean payment_completed=false;

public Booking() {}




public Booking(long booking_id, Date departure_date, LocalDate booking_date, FlightData flight,
		List<Passenger> passenger, int otp, boolean booking_cancelled, boolean checked_in,double total_amount,boolean payment_completed) {
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














}
