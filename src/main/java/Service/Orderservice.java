package Backend.Tender_Cocount.Service;

import Backend.Tender_Cocount.Model.Order;
import Backend.Tender_Cocount.Repository.Orderrepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Orderservice {

    private final Orderrepository orderrepository;

    public Orderservice(Orderrepository orderrepository) {
        this.orderrepository = orderrepository;
    }

    // Create order
    public Order createOrder(Order order) {

        order.setStatus("PENDING");

        return orderrepository.save(order);
    }

    // Get all orders
    public List<Order> getAllOrders() {

        return orderrepository.findAll();
    }

    // Get order by ID
    public Order getOrderById(String id) {

        return orderrepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Order not found"));
    }

    // Update order status
    public Order updateOrderStatus(
            String id,
            String status) {

        Order order = getOrderById(id);

        order.setStatus(status);

        return orderrepository.save(order);
    }
}