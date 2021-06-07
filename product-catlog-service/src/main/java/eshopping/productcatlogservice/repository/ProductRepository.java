package eshopping.productcatlogservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import eshopping.productcatlogservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
