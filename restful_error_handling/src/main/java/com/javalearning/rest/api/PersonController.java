package com.javalearning.rest.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javalearning.rest.exception.PersonException;
import com.javalearning.rest.model.Person;
import com.javalearning.rest.service.PersonService;

//http:/localhost:8080/api/v1/hello
@RestController
@RequestMapping("/person")
public class PersonController {
	
	private final static String OK_MESSAGE = "OK";
	private PersonService service;
	
	@Autowired
	public PersonController(PersonService service) {
		this.service = service;
	}
	
	
	/*
	 * find person base on id, throw exception if can't found
	 */	
	@GetMapping(path = "/{id}")
	public Person getPerson(@PathVariable int id) throws Exception {
		return service.findById(id);
	}
	
	@GetMapping
	public List<Person> getAll() throws Exception {
		return service.getAll();
	}
	
	/*
	 * find person base on id, don't throw any exception
	 */	
	@GetMapping(path = "/nonexception/{id}")
	public Person getPersonWithNoException(@PathVariable int id) {
		try {
			Person p = service.findById(id);
			return p;
		}
		catch (PersonException exp) {
			System.out.println("No exception throw to client: " + exp);
		}
		
		return null;
	}
	
	
	@PostMapping
	public String addPerson(@RequestBody(required = false) Person person, 
										HttpServletRequest request) throws Exception {
		
		if (person == null) {
			throw new Exception("Can not detect person input");
		}
		
		System.out.println(person);
		
		service.addPerson(person);		
		return OK_MESSAGE;
	}
	
	
	
	
	@PutMapping(path = "/{id}")
	public String updateList(@PathVariable int id, 
								@RequestBody(required = false) Person p, 
			HttpServletRequest request) throws Exception {

		service.updatePerson(id, p);
		
		return OK_MESSAGE;
	}
	
	@DeleteMapping(path = "/{id}")
	public String updateList(@PathVariable int id) throws Exception {
		service.deletePerson(id);
		
		return OK_MESSAGE;
	}
	
}
