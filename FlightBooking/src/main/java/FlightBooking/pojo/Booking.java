package FlightBooking.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="booking")
public class Booking {
@Id
public int Booking_Id;

}
