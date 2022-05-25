package ApiGateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class fallbackController {

	@GetMapping("/searchFallback")
	public String searchFallBack() {
		return "Taking longer time  try again in a while";
		
	}
}
