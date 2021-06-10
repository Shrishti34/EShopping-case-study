package eshopping.productcatlogservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import eshopping.productcatlogservice.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

	public List<Product> findAllByCategory(String category);
    public List<Product> findAllByName(String name);
    
	
}