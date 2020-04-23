package com.javalearning.spring_bean_xml;

public class HelloSpringCore {
	
	private String msg;
	private String name;
	
	public HelloSpringCore(String message) {
		this.msg = message;
	}
	
	
	public String buildToString() {
		return msg + " " + name;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
