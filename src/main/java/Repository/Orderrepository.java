package Backend.Tender_Cocount.Repository;

import Backend.Tender_Cocount.Model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Orderrepository
        extends MongoRepository<Order, String> {
}