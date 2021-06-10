package eshopping.orderservice.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import eshopping.orderservice.domain.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, Long> {
}