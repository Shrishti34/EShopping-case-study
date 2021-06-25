package eshopping.userservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import eshopping.userservice.entity.User;

@Service
public interface UserService {

	List<User> getAllUsers();
    User getUserById(Long id);
    User getUserByName(String userName);
    User saveUser(User user);
}
