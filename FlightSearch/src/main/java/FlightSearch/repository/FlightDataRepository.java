package FlightSearch.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import FlightSearch.pojo.Flight;
import FlightSearch.pojo.FlightData;

@Repository
public interface FlightDataRepository extends MongoRepository<FlightData,Integer> {
	
	

	 
		
	
}


