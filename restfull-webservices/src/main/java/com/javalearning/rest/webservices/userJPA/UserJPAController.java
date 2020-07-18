package com.javalearning.rest.webservices.userJPA;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javalearning.rest.webservices.user.Post;
import com.javalearning.rest.webservices.user.User;
import com.javalearning.rest.webservices.user.exception.UserNotFoundException;


@RestController
@RequestMapping("/jpa")
public class UserJPAController {

	@Autowired
	UserRepository userRepository;
	
	
	@GetMapping("/users")
	public List<User> getAll(){
		return userRepository.findAll();
	}
	
	
	@GetMapping("/users/{id}")
	public Optional<User> findUserById(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		
		if (!user.isPresent()) {
			throw new UserNotFoundException("Can not found user with id: " + id);
		}
		
		return user;
	}
	
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
	}
	
	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		User savedUser = userRepository.save(user);
		
		
		return savedUser;
	}
	
	
	@GetMapping("/users/{id}/posts")
	public List<Post> findPostById(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		
		if (!user.isPresent()) {
			throw new UserNotFoundException("Can not found user with id: " + id);
		}
		
		return user.get().getPosts();
	}
	
}
