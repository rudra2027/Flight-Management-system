package FlightBooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import FlightBooking.pojo.Booking;

@Service
public class EmailService {
	
	@Autowired
	JavaMailSender javaMailSender;

	public String sendEmail(Booking booking) {
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("rudransh3067@gmail.com");
		//Taking user mail via Rest Template from user Db/Security Microservice
		message.setTo("rudra1234ag@gmail.com");
		message.setSubject("Booking Confirmation Mail");
		message.setText("Successfull Booking With PNR Number: "+booking.getBooking_id()+",  Passeger Details: "+booking.getPassenger()+",  Departue Details: "+booking.getDeparture_date() );
		
		javaMailSender.send(message);
		
		return "Booking Mail sent successfully";
	}

	public Booking checkIn(Booking booking) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("rudransh3067@gmail.com");
		//Taking user mail via Rest Template from user Db/Security Microservice
		message.setTo("rudra1234ag@gmail.com");
		message.setSubject("Checked-In");
		message.setText("Successfull Check-In With PNR Number: "+booking.getBooking_id());
		
		javaMailSender.send(message);
		return booking;
		
		
	}

	public Booking bookingCancelled(Booking booking) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("rudransh3067@gmail.com");
		//Taking user mail via Rest Template from user Db/Security Microservice
		message.setTo("rudra1234ag@gmail.com");
		message.setSubject("Booking Cancelled");
		message.setText("Booking Cancelled for PNR Number: "+booking.getBooking_id()+" If Paid Respective Refund will be initiated shortly (Terms & Conditions Applied)  ");
		
		javaMailSender.send(message);
		return booking;
	}
}