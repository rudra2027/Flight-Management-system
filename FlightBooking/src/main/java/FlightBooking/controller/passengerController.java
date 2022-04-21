package FlightBooking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FlightBooking.pojo.Passenger;
import FlightBooking.repository.PassengerRepository;

@RestController
@RequestMapping("/book")
public class passengerController {
@Autowired
public PassengerRepository pas_repo;

@GetMapping("/allPassengers")
public List<Passenger> getPassengers(){
	return pas_repo.findAll();
}

@GetMapping("/passenger/{pas_id}")
public Optional<Passenger> getPassengerById(@PathVariable("pas_id") int pas_id){
	return pas_repo.findById(pas_id);
}

@PostMapping("/addPassenger")
public String addPassenger(@RequestBody Passenger passenger) {
	pas_repo.save(passenger);
	return "Passenger Added:"+passenger.getPassenger_name();
	
}
@DeleteMapping("/delete/{id}")
public String deletePassenger(@PathVariable("id") int id) {
	pas_repo.deleteById(id);
	return "Deleted:"+id;
}
}
