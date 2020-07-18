package com.spring.microservice.limitsservice;

public class LimitConfiguration {
	int maximum;
	int minumum;
	
	protected LimitConfiguration() {
		
	}
	
	
	public LimitConfiguration(int maximum, int minumum) {
		this.maximum = maximum;
		this.minumum = minumum;
	}
	
	
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	public int getMinumum() {
		return minumum;
	}
	public void setMinumum(int minumum) {
		this.minumum = minumum;
	}
	
	
}
