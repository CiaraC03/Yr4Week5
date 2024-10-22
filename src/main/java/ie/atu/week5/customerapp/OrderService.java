package ie.atu.week5.customerapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public List<Order> getOrderByCustomerId(String customerId){
        List<Order> orders = orderRepository.findByCustomerId(customerId);
        return orders;
    }

    public Order createOrder(Order order){
        Order savedOrder = orderRepository.save(order);
        return savedOrder;
    }

    public Void deleteOrder(String id){
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }


    }
}
