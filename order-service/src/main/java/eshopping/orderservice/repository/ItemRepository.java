package eshopping.orderservice.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import eshopping.orderservice.domain.Item;



@Repository
public interface ItemRepository extends MongoRepository<Item, Long> {
}
