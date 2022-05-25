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

	public String sendEmail(Booking booking,String mailId) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("rudransh3067@gmail.com");
		//Taking user mail via Rest Template from user Db/Security Microservice
		message.setTo(mailId);
		message.setSubject("Booking Confirmation Mail");
		message.setText("Successfull Booking With PNR Number: "+booking.getBooking_id() +",  Passegers: "+booking.getPassenger().size()+",  Departue Details: "+booking.getDeparture_date() );
		
		javaMailSender.send(message);
		
		return "Booking Mail sent successfully";
	}

	public Booking checkIn(Booking booking,String mailId) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("rudransh3067@gmail.com");
		//Taking user mail via Rest Template from user Db/Security Microservice
		message.setTo(mailId);
		message.setSubject("Checked-In");
		message.setText("Successfull Check-In With PNR Number: "+booking.getBooking_id());
		
		javaMailSender.send(message);
		return booking;
		
		
	}

	public Booking bookingCancelled(Booking booking,String mailId) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("rudransh3067@gmail.com");
		//Taking user mail via Rest Template from user Db/Security Microservice
		message.setTo(mailId);
		message.setSubject("Booking Cancelled");
		message.setText("Booking Cancelled for PNR Number: "+booking.getBooking_id()+" If Paid Respective Refund will be initiated shortly (Terms & Conditions Applied)  ");
		
		javaMailSender.send(message);
		return booking;
	}
}