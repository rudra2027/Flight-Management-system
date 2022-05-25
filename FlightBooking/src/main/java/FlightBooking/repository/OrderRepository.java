package FlightBooking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import FlightBooking.pojo.Order;
 
 
@Repository
public interface OrderRepository extends MongoRepository<Order,String> {
 
    Order findByRazorpayOrderId(String orderId);
}
