package CheckIn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import ChekIn.pojo.Booking;



@Service
public class EmailService {
	
	@Autowired
	JavaMailSender javaMailSender;

	public String sendEmail(Booking booking,String mailId) {
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("rudransh3067@gmail.com");
		//Taking user mail via Rest Template from user Db/Security Microservice
		message.setTo(mailId);
		message.setSubject("CheckIn Confirmation Mail");
		message.setText("CheckIn Successful"+booking.getBooking_id() );
		
		javaMailSender.send(message);
		
		return " CheckIn Mail sent successfully";
	}
}
