package com.javalearning.spring_boot_demo.repository;

import org.springframework.stereotype.Repository;

@Repository
public class GreeterRepository {
	
	public String getInfoByName(String name) {
		return name.toUpperCase() + " from Service";
	}
	
}
