package com.javalearning.rest.webservices.user;

import java.net.URI;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.javalearning.rest.webservices.user.exception.UserNotFoundException;

@RestController
public class UserController {
	
	@Autowired
	private UserDaoService userService;
	
	@GetMapping("/users")
	public List<User> findAll(){
		return userService.findAll();
	}
	
	@GetMapping("/users/from/{from}/to/{to}")
	public List<User> findAll(@PathVariable int from, @PathVariable int to){
		List<User> users = userService.findAll(from, to);
		
		if (users.isEmpty()) {
			throw new UserNotFoundException("Can not found users from: " + from + " to " + to);
		}
		
		return users;
	}
	
	
	@GetMapping("/users/{id}")
	public User findOne(@PathVariable int id){
		User user = userService.findOne(id);
		
		if (user == null) {
			throw new UserNotFoundException("Can not found user-id: " + id);
		}
		
		
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> add(@Valid @RequestBody User user){
		User savedUser = userService.add(user);
		
		//Created
		// /user/{id} savedUser.getId()
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
													.path("/{id}")
													.buildAndExpand(savedUser.getId())
													.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable int id){
		boolean rs = userService.delete(id);
		if (!rs) {
			throw new UserNotFoundException("user-id: " + id + " is not available");
		}
	}
	
	
	
	
	
	
	
}
