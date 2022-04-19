package FlightSearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import FlightSearch.pojo.Flight;
import FlightSearch.repository.FlightSearchRepository;

@RestController
public class FlightSearchController {
	@Autowired
	public FlightSearchRepository frepo;
	
	@GetMapping("/all")
	public List<Flight> getAllFlights(){
		return frepo.findAll();		
	}
	
	@GetMapping("/find/{departure_location}/{arrival_location}/{departure_date}")
	public List<Flight> getFlightByData(@PathVariable("departure_location") String dep_loc,@PathVariable("arrival_location") String arr_loc,@PathVariable("departure_date") String dep_date ){
		return frepo.findByData(dep_loc, arr_loc, dep_date)	;	
	}
	
	@PostMapping("/add")
	public String addFlight(@RequestBody Flight flight) {
		frepo.save(flight);
	return "Added Flight:" +flight.getFlight();
	}

}
