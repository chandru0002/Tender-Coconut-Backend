package Backend.Tender_Cocount.Repository;

import Backend.Tender_Cocount.Model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Productrepository extends MongoRepository<Product, String> {

}