package FlightBooking.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import FlightBooking.pojo.Passenger;

public interface PassengerRepository extends MongoRepository<Passenger,Integer> {
	@Query("{'passenger_name' : :#{#passenger_name}}")
List<Passenger> findByName(@Param("passenger_name") String passenger_name);


}
