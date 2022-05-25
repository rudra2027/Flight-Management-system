package FlightSearch;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import FlightSearch.controller.FlightSearchController;
import FlightSearch.pojo.Flight;
import FlightSearch.pojo.FlightData;
import FlightSearch.repository.FlightDataRepository;
import FlightSearch.repository.FlightSearchRepository;

@SpringBootTest
class FlightSearchApplicationTests {
@MockBean	
private FlightSearchRepository frepo;

private FlightDataRepository fdrepo;
@InjectMocks
private  FlightSearchController fcont;
	@Test
	void Flights() {
		/*
		 * Flight flight=new Flight(); List<Flight> flight1=Arrays.asList(new
		 * Flight(),new Flight()); when(fcont.getFlightByData("Mumbai",
		 * "Delhi")).thenReturn(flight1); assertEquals(2,fcont.getFlightByData("Mumbai",
		 * "Delhi").size());
		 */
		 List<Flight> flight = fcont.getAllFlights();
		    assertThat(flight).size().isGreaterThan(0);
	}

}
