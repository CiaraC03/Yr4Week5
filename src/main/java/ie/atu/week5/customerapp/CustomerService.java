package ie.atu.week5.customerapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomerById(String id){
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return Optional<customer>;
        } else {
            return new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public List<Customer> createCustomer(Customer customer){
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }

    public List<Void> deleteCustomer(String id){
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return ResponseStatusException(HttpStatus.NOT_FOUND)


}
