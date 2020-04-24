package com.javalearning.spring_bean_annotation.components;

import org.springframework.stereotype.Component;

/*
 * add annotation @Component and name="acbBankComponent" so that this class could be created to spring context, 
 * getBean function
 * In this case, 
 * + springContext.getBean("acbBankComponent", VNBank.class); or
 * + springContext.getBean("acbBankComponent", IBank.class);
 */

@Component("acbBankComponent") 
public class ACBBank implements IBank {
	
	String message = null;
	public ACBBank() {
		System.out.println(" -> ACBBank Bean in acbBankComponent component");
		message = "default";
	}
	
	public ACBBank(String msg) {
		message = msg;
	}

	@Override
	public String getName() {
		return "ACB Bank - welcome";
	}
	
	
	public String getEmail() {
		return "admin@acb.com";
	}

	public String getMessage() {
		return message;
	}
	
	

}
