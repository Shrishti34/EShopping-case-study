package eshopping.userservice.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import eshopping.userservice.entity.UserDetails;



@Repository
public interface UserDetailsRepository extends MongoRepository<UserDetails, Long> {
}