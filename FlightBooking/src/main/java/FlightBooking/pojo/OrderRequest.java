package FlightBooking.pojo;

import lombok.Data;

@Data
public class OrderRequest {
    private String userName;
    private String customerName;
    private String email;
    private String phoneNumber;
    private String amount;
}