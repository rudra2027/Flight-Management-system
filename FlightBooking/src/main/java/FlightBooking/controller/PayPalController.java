package FlightBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

import FlightBooking.pojo.Booking;
import FlightBooking.pojo.Order;
import FlightBooking.service.PayPalService;



@Controller
public class PayPalController {

	@Autowired
	PayPalService service;
	@Autowired
	private RestTemplate restTemplate;

	public static final String SUCCESS_URL = "pay/success";
	public static final String CANCEL_URL = "pay/cancel";
	// Getting to home page in html(Payment-form) 
	
	@GetMapping("/")
	public String home() {
		return "home";
	}

//Based on data filled up in form  return Status(moving to success.html)	/can Cancel(moving to cancel.html)	
	@PostMapping("/pay")
	public String payment(@ModelAttribute("order") Order order) {
		try {
			Payment payment = service.createPayment(order.getPrice(), order.getCurrency(), order.getMethod(),
					order.getIntent(), order.getDescription(), "http://localhost:8082/" + CANCEL_URL,
					"http://localhost:8082/" + SUCCESS_URL);
			for(Links link:payment.getLinks()) {
				if(link.getRel().equals("approval_url")) {
					return "redirect:"+link.getHref();
				}
			}
			
		} catch (PayPalRESTException e) {
		
			e.printStackTrace();
		}
		return "redirect:/";
	}
	//Getting status for cancellation 
	 @GetMapping(value = CANCEL_URL)
	    public String cancelPay() {
	        return "cancel";
	    }
		//Getting status for payment success 

	    @GetMapping(value=SUCCESS_URL)
	    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
         
         
	    	try {
	            Payment payment = service.executePayment(paymentId, payerId);
	            System.out.println(payment.toString());
	            if (payment.getState().equals("approved")) {
	            
	                return "success";
	            }
	        } catch (PayPalRESTException e) {
	         System.out.println(e.getMessage());
	        }
	        return "redirect:/";
	    }
	    @PutMapping("/Payment/{booking_id}")
	    public Booking payment_sucess(@RequestParam Booking booking,@PathVariable long booking_id) throws PayPalRESTException {
	   Payment payment=new Payment();
		if(payment.getState().equals("approved")) {
			booking.setPayment_completed("success");
		}
		return booking;
	    }

}
