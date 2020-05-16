package com.javalearning.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalearning.rest.dao.PersonDAO;
import com.javalearning.rest.exception.PersonException;
import com.javalearning.rest.model.Person;

@Service
public class PersonService {
	
	@Autowired
	PersonDAO personDAO;
	
	
	public void addPerson(Person p) throws PersonException {
		
		if (!p.valid()) {
			throw new PersonException("The person is invalid: " + p);
		}
		
		boolean canAdd = personDAO.add(p);
		if (!canAdd) {
			throw new PersonException("Can not add the person: " + p);
		}
	}
	
	public Person findById(int id) throws PersonException {
		Optional<Person> person = personDAO.findById(id);
		
		if (person.isPresent()) {
			return person.get();
		}
		
		throw new PersonException("Can NOT found person with id = " + id);		
	}

	public List<Person> getAll() {
		return personDAO.getAll();
	}
	
	
	public void updatePerson(int id, Person p) throws PersonException {
		if (!p.valid()) {
			throw new PersonException("The person is invalid: " + p);
		}
		
		
		boolean updated = personDAO.update(id, p);
		if (updated == false) {
			throw new PersonException("Can not update this person due to invalid Id");
		}
	}
	
	
	public void deletePerson(int id) throws PersonException {
		boolean deleted = personDAO.delete(id);
		if (deleted == false) {
			throw new PersonException("Can not delete this person due to invalid Id");
		}
	}
	
	
	
}
