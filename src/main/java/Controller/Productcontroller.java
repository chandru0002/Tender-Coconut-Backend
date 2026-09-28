package Backend.Tender_Cocount.Controller;

import Backend.Tender_Cocount.Model.Product;
import Backend.Tender_Cocount.Service.Productservice;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:5173")
public class Productcontroller {

    private final Productservice productservice;

    public Productcontroller(Productservice productservice) {
        this.productservice = productservice;
    }

    // GET all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productservice.getAllProducts();
    }

    // GET product by ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {
        return productservice.getProductById(id);
    }

    // ADD product
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productservice.addProduct(product);
    }

    // UPDATE product
    @PutMapping("/{id}")
    public Product updateProduct(
            @PathVariable String id,
            @RequestBody Product product) {

        return productservice.updateProduct(id, product);
    }

    // DELETE product
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable String id) {

        productservice.deleteProduct(id);

        return "Product deleted successfully";
    }
}