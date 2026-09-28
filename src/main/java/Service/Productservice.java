package Backend.Tender_Cocount.Service;

import Backend.Tender_Cocount.Model.Product;
import Backend.Tender_Cocount.Repository.Productrepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Productservice {

    private final Productrepository productrepository;

    public Productservice(Productrepository productrepository) {
        this.productrepository = productrepository;
    }

    // Get all products
    public List<Product> getAllProducts() {
        return productrepository.findAll();
    }

    // Get product by ID
    public Product getProductById(String id) {
        return productrepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));
    }

    // Add product
    public Product addProduct(Product product) {
        return productrepository.save(product);
    }

    // Update product
    public Product updateProduct(String id, Product updatedProduct) {

        Product product = getProductById(id);

        product.setName(updatedProduct.getName());
        product.setPrice(updatedProduct.getPrice());
        product.setQuantity(updatedProduct.getQuantity());
        product.setAvailable(updatedProduct.isAvailable());
        product.setDescription(updatedProduct.getDescription());
        product.setImage(updatedProduct.getImage());

        return productrepository.save(product);
    }

    // Delete product
    public void deleteProduct(String id) {

        Product product = getProductById(id);

        productrepository.delete(product);
    }
}