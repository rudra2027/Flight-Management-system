package FlightSearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import FlightSearch.pojo.Flight;
import FlightSearch.pojo.FlightData;
import FlightSearch.repository.FlightSearchRepository;

@RestController
public class FlightSearchController {
	@Autowired
	public FlightSearchRepository frepo;
	
	@GetMapping("/allFlights")
	public List<Flight> getAllFlights(){
		return frepo.findAll();		
	}
	
	@GetMapping("/find/{departure_location}/{arrival_location}")
	public List<Flight> getFlightByData(@PathVariable("departure_location") String dep_loc,@PathVariable("arrival_location") String arr_loc){
		return frepo.findByData(dep_loc, arr_loc)	;	
	}
	
	@PostMapping("/addFlights")
	public String addFlight(@RequestBody Flight flight) {
		frepo.save(flight);
	return "Added Flight:" +flight.getFlight();
	}
	
	@PutMapping("/updateFlightsData/{id}")
	public Flight updateFlight(@RequestBody Flight flight,@PathVariable("id") int flights_id){
		flight.setId(flights_id);
		frepo.save(flight);
		return flight;
		
	}
	
	 
	 

}
