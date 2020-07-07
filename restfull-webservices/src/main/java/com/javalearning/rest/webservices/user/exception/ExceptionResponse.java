package com.javalearning.rest.webservices.user.exception;

import java.util.Date;

public class ExceptionResponse {
	private Date timestamp;
	private String message;
	private String detail;
	
	

	
	public ExceptionResponse(String message, String detail) {
		this.timestamp = new Date();
		this.message = message;
		this.detail = detail;
	}
	
	
	public Date getTimestamp() {
		return timestamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDetail() {
		return detail;
	}
	
	
}
