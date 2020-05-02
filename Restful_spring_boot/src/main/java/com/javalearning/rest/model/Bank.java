package com.javalearning.rest.model;

import java.util.UUID;

public class Bank {
	
	private UUID id;
	private String name;
	
	public Bank(UUID id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Bank(String name) {
		this.id = UUID.randomUUID();
		this.name = name;
	}

	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}
