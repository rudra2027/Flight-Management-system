package FlightSearch.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FlightSearch.pojo.Flight;
import FlightSearch.pojo.FlightData;
import FlightSearch.repository.FlightDataRepository;
import FlightSearch.repository.FlightSearchRepository;

@RestController
@RequestMapping("/Search")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FlightSearchController {
	@Autowired
	public FlightSearchRepository frepo;
	@Autowired
	public FlightDataRepository fdrepo;
	//Getting List Of all flights 
	
	@GetMapping("/allFlights")
	public List<Flight> getAllFlights(){
		return frepo.findAll();		
	}
	
	//Getting list of Flight from location to destination
	
	@GetMapping("/find/{departure_location}/{arrival_location}")
	public List<Flight> getFlightByData(@PathVariable("departure_location") String dep_loc,@PathVariable("arrival_location") String arr_loc){
		return frepo.findByData(dep_loc, arr_loc)	;	
	}
	
	//Getting Flight details (timings/seat_data)
	//error:giving whole flight but need flight data!!!!
	
	@GetMapping("/findFlight/{flight_id}")
	public Stream<Object> getFlight(@PathVariable("flight_id") int flight_id){
		List<Flight> flight=frepo.findByFlight_Id(flight_id);
		
	return flight.stream().map(d->d.getFlight())  ;
	
	}
	
	
	// For Admin to add new Flight
	
	@PostMapping("/addFlights")
	public String addFlight(@RequestBody Flight flight) {
		frepo.save(flight);
	return "Added Flight:" +flight.getFlight();
	}
	
	@PostMapping("/addFlightData")
	public String addFlightData(@RequestBody FlightData flight) {
		fdrepo.save(flight);
		return "Added Flight: "+flight.getFlight_id();
	
	}
	// For Admin to update Flight
	
	@PutMapping("/updateFlightsData/{id}")
	public FlightData updateFlight(@RequestBody FlightData flight,@PathVariable("id") int flights_id){
		flight.setFlight_id(flights_id);
		fdrepo.save(flight);
		return flight;
		
	}
	
	 
	 

}
