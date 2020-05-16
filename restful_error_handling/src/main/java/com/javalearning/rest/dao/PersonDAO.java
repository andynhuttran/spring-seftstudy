package com.javalearning.rest.dao;

import java.util.List;
import java.util.Optional;

import com.javalearning.rest.model.Person;

public interface PersonDAO {

	Optional<Person> findById(int id);
	
	List<Person> getAll();
	
	boolean add(Person p);
	
	boolean delete(int id);
	
	boolean update(int id, Person p);
	
}
