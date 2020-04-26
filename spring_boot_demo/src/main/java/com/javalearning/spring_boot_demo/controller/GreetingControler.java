package com.javalearning.spring_boot_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javalearning.spring_boot_demo.repository.GreeterRepository;

@RestController
public class GreetingControler {
	
	@Autowired
	private GreeterRepository service = null;
	
	/*public GreetingControler(GreeterRepository service) {
		this.service = service;
	}*/

	@RequestMapping(value = {"/greeter/{name}", "/greeter", "/say"})
	public Greeter greetingToClient(@PathVariable(required = false) String name) {
		String msg = (name==null)? "world": name;
		
		Greeter greeter = null;
		
		msg = service.getInfoByName(msg);
		
		if (msg.equalsIgnoreCase("cole")) {
			greeter = new Greeter("I dont know who you are");
		}
		else {
			greeter = new Greeter("Hello " + msg);
		}
		
		System.out.println(greeter.getMessage());
		
		return greeter;
	}
}
