package com.javalearning.spring_boot_demo.controller;

import java.sql.Timestamp;
import java.util.Objects;

public class Greeter {
	String message;
	Timestamp time;
	
	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public Greeter(String message) {
		this.message = message;
		time = new Timestamp(System.currentTimeMillis());
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Greeter)) return false;
		if (this == other) return true;
		
		Greeter g = (Greeter)other;
		return this.getMessage().equals(g.getMessage());		
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(getMessage());
	}
	
	
	
	
	
}
