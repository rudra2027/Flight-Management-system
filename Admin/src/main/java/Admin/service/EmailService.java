package Admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import Admin.pojo.Flight;





@Service
public class EmailService {
	
	@Autowired
	JavaMailSender javaMailSender;

	public String sendEmail(Flight flight) {
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("rudransh3067@gmail.com");
		//Taking user mail via Rest Template from user Db/Security Microservice
		message.setTo("adarsh.ag15@gmail.com");
		message.setSubject("Updates From FlightBuzz");
		message.setText("CheckIn Successful");
		
		javaMailSender.send(message);
		
		return " CheckIn Mail sent successfully";
	}
}
