package com.javalearning.rest.exception;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ErrorApi {
	private HttpStatus status;
	private String message;
	private List<String> details;
	private Timestamp created_at;
	
	public ErrorApi(HttpStatus status, String message, List<String> details) {
		this.status = status;
		this.message = message;
		this.details = details;
		
		created_at = new Timestamp(System.currentTimeMillis());
	}
	
	public ErrorApi(HttpStatus status, String message, String error) {
		this(status, message, Arrays.asList(error));
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
	
	public List<String> getDetails() {
		return details;
	}
	
	public void setDetails(List<String> details) {
		this.details = details;
	}
	
	public Timestamp getCreatedAt() {
		return created_at;
	}
	
	public void setCreatedAt(Timestamp created_at) {
		this.created_at = created_at;
	}
	
	
	
	
	
}
