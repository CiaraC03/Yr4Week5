package ie.atu.week5.customerapp;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Document(collection = "customers")
public class Customer {

    @Id
    @Min(value = 1, message = "postive and greater than 1")
    private String id;

    @NotBlank(message= "Name must not be blank")
    private String name;

    @Email(message = "Email must be valid")
    private String email;
}