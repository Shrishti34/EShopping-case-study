package eshopping.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import eshopping.userservice.entity.User;
import eshopping.userservice.repository.UserRepository;


@Service
@Transactional
public class UserServiceImpl {

	 @Autowired
	 private UserRepository userRepository;
	 
	 	@Override
	    public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }

	 	@Override
	 	public User getUserById(Long id) {
	        return userRepository.getOne(id);
	    }

	 	@Override
	    public User getUserByName(String userName) {
	        return userRepository.findByUserName(userName);
	    
	    }
}
