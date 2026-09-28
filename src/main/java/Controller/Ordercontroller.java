package Backend.Tender_Cocount.Controller;

import Backend.Tender_Cocount.Model.Order;
import Backend.Tender_Cocount.Service.Orderservice;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:5173")
public class Ordercontroller {

    private final Orderservice orderservice;

    public Ordercontroller(Orderservice orderservice) {
        this.orderservice = orderservice;
    }

    // CREATE ORDER
    @PostMapping
    public Order createOrder(@RequestBody Order order) {

        return orderservice.createOrder(order);
    }

    // GET ALL ORDERS
    @GetMapping
    public List<Order> getAllOrders() {

        return orderservice.getAllOrders();
    }

    // GET ORDER BY ID
    @GetMapping("/{id}")
    public Order getOrderById(
            @PathVariable String id) {

        return orderservice.getOrderById(id);
    }

    // UPDATE ORDER STATUS
    @PutMapping("/{id}/status")
    public Order updateOrderStatus(
            @PathVariable String id,
            @RequestParam String status) {

        return orderservice.updateOrderStatus(
                id,
                status
        );
    }
}