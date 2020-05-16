package com.javalearning.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestfulErrorHandlingApplication {

	public static void main(String[] args) {
		//set context path
		System.setProperty("server.servlet.context-path", "/api/v1");
		SpringApplication.run(RestfulErrorHandlingApplication.class, args);
	}

}
