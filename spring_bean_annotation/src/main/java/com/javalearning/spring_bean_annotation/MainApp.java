package com.javalearning.spring_bean_annotation;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.javalearning.spring_bean_annotation.components.ACBBank;
import com.javalearning.spring_bean_annotation.components.IBank;
import com.javalearning.spring_bean_annotation.services.IBankService;

public class MainApp {

	public static void main(String[] args) {
		
		System.out.println("Before loading Bean");
		AnnotationConfigApplicationContext springContext = 
				new AnnotationConfigApplicationContext(SpringConfiguration.class);
		System.out.println("After loading Bean");
		
		System.out.println("---------------");
		IBank abcBank = springContext.getBean("acbBankComponent", IBank.class);
		System.out.println("abcBank.getName(): " + abcBank.getName());		
		
		
		System.out.println("---------------");
		IBank vnBank = springContext.getBean("VNBank", IBank.class);
		System.out.println("VNBank.getName(): " + vnBank.getName());
		
		
		System.out.println("---------------");
		ACBBank greatACBBank = springContext.getBean("getGreatACBBank", ACBBank.class);
		System.out.println("greatACBBank.getEmail(): " + greatACBBank.getEmail());
		System.out.println("greatACBBank.getMessage(): " + greatACBBank.getMessage());
		System.out.println("greatACBBank.getName(): " + greatACBBank.getName());
		
		System.out.println("---------------");
		IBankService bankService = springContext.getBean("bankService", IBankService.class);
		List<IBank> banks = bankService.getAvailableBanks();
		
		System.out.println(String.format("There are %s banks from Ioc Container", banks.size()));
		for (IBank bank : banks) {
			System.out.println(bank.getName());
		}
		
		
		springContext.close();

	}

}
