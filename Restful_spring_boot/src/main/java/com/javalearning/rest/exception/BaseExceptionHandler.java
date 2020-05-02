package com.javalearning.rest.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class BaseExceptionHandler extends ResponseEntityExceptionHandler {
	
	//handle all exceptions
	@ExceptionHandler({ Throwable.class })
	public ResponseEntity<Object> handleCommonException(
			Throwable ex, 
			WebRequest request) {

		String message = "There is a internal error at Server";		
	    ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, 
	    								message, 
	    								"unknow handle error: " + ex.getMessage());

	    return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}
	
	//handle wrong parameter
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<Object> handleMethodArgumentTypeMismatch(
			MethodArgumentTypeMismatchException ex, 
			WebRequest request) {
		
	    String error = ex.getName() + " should be of type " + ex.getRequiredType().getName();
	    
	    ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
	    
	    return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}
	
	//handle Bank exception
	@ExceptionHandler({ BankException.class })
	public ResponseEntity<Object> handleBankException(
			BankException ex, 
			WebRequest request) {

		String message = "There is a bad request to Bank";		
	    ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, message, ex.getLocalizedMessage());	    
	    return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}
	
	
}
