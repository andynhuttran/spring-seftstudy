package com.javalearning.spring_bean_annotation.components;

import org.springframework.stereotype.Component;

/*
 * add annotation @Component so that this class could be created to spring context, getBean function
 * In this case, 
 * + springContext.getBean("VNBank", VNBank.class); or
 * + springContext.getBean("VNBank", IBank.class);
 */

@Component
public class VNBank implements IBank {

	public VNBank() {
		System.out.println(" -> VNBank Bean in VNBank component");
	}
	
	@Override
	public String getName() {
		return "Vietnam Bank";
	}
	
	public String getAddress() {
		return "123 XYZ street, Cole city, VN";
	}

}
