package com.javalearning.rest.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * By default, String don't convert String to any Data or Time object
 * We need to add @DateTimeFormat before a parameter
 */

@RestController
@RequestMapping("/api/v1")
public class DateController {

	@PostMapping("/date")
	public Date date(@RequestParam("date")
					@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) 
					Date date) {
		
		System.out.println("date: " + date);
		
		return date;
	}
	
	
	@PostMapping("/local-date")
	public LocalDate localDate(@RequestParam("localDate")
						@DateTimeFormat(pattern = "yyyy-MM-dd")
						LocalDate localDate) {
		
		System.out.println("localDate: " + localDate);
		
		return localDate;
	}
	
	
	@PostMapping("/local-date-time")
	public LocalDateTime localDateTime(@RequestParam("localDateTime")
						@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
						LocalDateTime localDateTime) {
		
		System.out.println("localDateTime: " + localDateTime);
		
		return localDateTime;
	}

	
	
	
	
}


















