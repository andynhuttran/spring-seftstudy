package com.javalearning.rest.exception;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiError {
	private HttpStatus status;
	private String message;
	private List<String> errors;
	private Timestamp created_at;
	
	public ApiError(HttpStatus status, String message, List<String> errors) {
		this.status = status;
		this.message = message;
		this.errors = errors;
		created_at = new Timestamp(System.currentTimeMillis());
	}
	
	
	public ApiError(HttpStatus status, String message, String error) {
		this.status = status;
		this.message = message;
		this.errors = Arrays.asList(error);
		created_at = new Timestamp(System.currentTimeMillis());
	}


	public HttpStatus getStatus() {
		return status;
	}


	public void setStatus(HttpStatus status) {
		this.status = status;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public List<String> getErrors() {
		return errors;
	}


	public void setErrors(List<String> errors) {
		this.errors = errors;
	}


	public Timestamp getCreated_at() {
		return created_at;
	}


	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	
	
	
	
	
	
	
	
	
}
