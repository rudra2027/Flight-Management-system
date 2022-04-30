package FlightSearch.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import FlightSearch.pojo.Flight;
import FlightSearch.pojo.FlightData;

@Repository
public interface FlightSearchRepository extends MongoRepository<Flight,Integer> {
	@Query("{'departure_location' : :#{#departure_location}, 'arrival_location' : :#{#arrival_location}}")
	List<Flight> findByData(@Param("departure_location") String departure_location, @Param("arrival_location") String arrival_location);

	
	@Query("{'flight.flight_id':?0}")
	List<Flight> findByFlight_Id(@Param ("flight_id")int flight_id );
	

	 
		
	
}


