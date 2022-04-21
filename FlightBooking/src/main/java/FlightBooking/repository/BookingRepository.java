package FlightBooking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import FlightBooking.pojo.Booking;

public interface BookingRepository extends MongoRepository<Booking,Integer> {

}
