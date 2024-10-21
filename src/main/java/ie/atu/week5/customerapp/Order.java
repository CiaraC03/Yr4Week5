package ie.atu.week5.customerapp;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "orders")
public class Order {

    @Id
    @Min(value = 1, message = "postive and greater than 1")
    private String id;

    @NotBlank(message= "Order Code must not be blank")
    private int orderCode;

    @NotBlank(message= "Order Details must not be blank")
    private String orderDetails;

    @NotBlank(message= "Order Date must not be blank")
    private String orderDate;

    @NotBlank(message= "Customer Id must not be blank")
    private String customerId; // Reference to the associated customer
}
