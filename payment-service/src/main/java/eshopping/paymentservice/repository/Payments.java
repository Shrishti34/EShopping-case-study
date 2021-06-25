package eshopping.paymentservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import eshopping.paymentservice.domain.Payment;

public interface Payments extends MongoRepository<Payment, String> {

}