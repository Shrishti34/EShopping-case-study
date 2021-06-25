package eshopping.userservice.repository;


import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import eshopping.userservice.entity.User;

@Repository

public interface UserRepository extends MongoRepository<User, String > {
   
	List<User> findByFName(String FName);
	List<User> findByCustmEmail(String CustmEmail);
	List<User> findAll();
}
