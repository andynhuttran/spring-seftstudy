package com.javalearning.rest.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.javalearning.rest.model.Person;


@Repository
public class FakePersonDAO implements PersonDAO {

	List<Person> people = new ArrayList<Person>();
	
	public FakePersonDAO() {
		people.add(new Person(1, "Cole", 32));
		people.add(new Person(2, "Andy", 20));
		people.add(new Person(3, "Bella", 29));
		people.add(new Person(4, "Katoza", 26));
		people.add(new Person(5, "Susan", 24));
		
	}
	
	@Override
	public Optional<Person> findById(int id) {
		return people.parallelStream()
				.filter(p -> p.getId() == id)
				.findFirst();
	}

	@Override
	public List<Person> getAll() {
		return people;
	}

	@Override
	public boolean add(Person p) {		
		if (findById(p.getId()).isPresent()) {
			return false;
		}
		
		people.add(p);
		return true;
	}

	@Override
	public boolean delete(int id) {
		return people.removeIf(p -> p.getId() == id);
	}

	@Override
	public boolean update(int id, Person p) {
		Optional<Person> person = findById(id);
		
		if (person.isPresent()) {
			
			Person oldP = person.get();			
			oldP.setAge(p.getAge());
			oldP.setName(p.getName());
			
			return true;
		}
		
		return false;
	}

}
