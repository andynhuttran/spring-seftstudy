package com.spring.microservice.currencyexchange;

import java.math.BigDecimal;

public class ExchangeValue {
	
	private long id;
	private String from;
	private String to;
	
	private BigDecimal coversionMultiple;

	
	
	public ExchangeValue() {
		
	}
	
	public ExchangeValue(long id, String from, String to, BigDecimal coversionMultiple) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.coversionMultiple = coversionMultiple;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getCoversionMultiple() {
		return coversionMultiple;
	}

	public void setCoversionMultiple(BigDecimal coversionMultiple) {
		this.coversionMultiple = coversionMultiple;
	}
	
	
}
