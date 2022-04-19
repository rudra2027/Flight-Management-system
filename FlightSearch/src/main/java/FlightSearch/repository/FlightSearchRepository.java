package FlightSearch.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import FlightSearch.pojo.Flight;

@Repository
public interface FlightSearchRepository extends MongoRepository<Flight,Integer> {
	@Query("{'departure_location' : :#{#departure_location}, 'arrival_location' : :#{#arrival_location},'departure_date': :#{#departure_date}}")
	List<Flight> findByData(@Param("departure_location") String departure_location, @Param("arrival_location") String arrival_location,@Param("departure_date") String departure_date);
}
