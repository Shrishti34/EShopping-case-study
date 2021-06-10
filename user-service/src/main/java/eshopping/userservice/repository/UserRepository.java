package eshopping.userservice.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import eshopping.userservice.entity.User;

@Repository

public interface UserRepository extends MongoRepository<User, String > {
   
	 User findByUserName(String userName);
}
