package FlightSearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FlightSearchApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(FlightSearchApplication.class, args);
		
	}

}
