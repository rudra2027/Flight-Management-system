package FlightBooking.pojo;

import java.io.Serializable;



import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
/**
 * The persistent class for the user_order database table.
 * 
 */
@EntityScan
@Document(collection = "user_order")
@NoArgsConstructor
@Getter
@Setter
public class Order implements Serializable {
 
    /**
     * 
     */
    private static final long serialVersionUID = 65981149772133526L;
 
   
    @Id
    private String userId;
 
    private String razorpayPaymentId;
 
    private String razorpayOrderId;
 
    private String razorpaySignature;
 
}