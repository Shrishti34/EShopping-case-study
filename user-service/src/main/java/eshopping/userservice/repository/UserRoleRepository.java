package eshopping.userservice.repository;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import eshopping.userservice.entity.UserRole;



@Repository
public interface UserRoleRepository extends MongoRepository<UserRole, Long> {
    UserRole findUserRoleByRoleName(String roleName);
}
