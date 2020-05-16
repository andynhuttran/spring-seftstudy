package com.javalearning.rest.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BaseException extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAll(Exception exp, WebRequest webRequest){
		
		ErrorApi errorApi = new ErrorApi(HttpStatus.INTERNAL_SERVER_ERROR, 
									"There is an unknow exception in Server", 
									exp.getMessage());
		
		return new ResponseEntity<Object>(errorApi, new HttpHeaders(), errorApi.getStatus());
	}
	
	
	
	@ExceptionHandler(PersonException.class) 
	public ResponseEntity<Object> handlePersonException(PersonException exp, WebRequest webRequest){
	  
		ErrorApi errorApi = new ErrorApi(HttpStatus.BAD_REQUEST, 
											"Person exception",
											exp.getMessage());
	  
		return new ResponseEntity<Object>(errorApi, new HttpHeaders(), errorApi.getStatus()); 
	}
	
	//handle wrong parameter
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<Object> handleMethodArgumentTypeMismatch(
			MethodArgumentTypeMismatchException ex, 
			WebRequest request) {
		
	    String error = ex.getName() + " should be of type " + ex.getRequiredType().getName();
	    
	    ErrorApi errorApi = new ErrorApi(HttpStatus.BAD_REQUEST, 
	    									"Paramater is wrong", 
	    									error);
	    
	    return new ResponseEntity<Object>(errorApi, new HttpHeaders(), errorApi.getStatus());
	}
	
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		
		ErrorApi errorApi = new ErrorApi(HttpStatus.BAD_REQUEST, 
										"Can not parse body",
										ex.getMessage());
		
		
		return new ResponseEntity<Object>(errorApi, headers, errorApi.getStatus());
	}
	
}
