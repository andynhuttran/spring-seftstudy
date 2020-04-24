package com.javalearning.spring_bean_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.javalearning.spring_bean_annotation.components.ACBBank;

/*
 * This class tell spring that:
 * There are beans in packages "com.javalearning.spring_bean_annotation.components" and
 * "com.javalearning.spring_bean_annotation.services".
 * Spring should scan bean on that.
 * 
 * Beside that, in this file, you can create your own bean with @Bean annotation
 */

@Configuration
@ComponentScan({"com.javalearning.spring_bean_annotation.components",
				"com.javalearning.spring_bean_annotation.services"
				})
public class SpringConfiguration {

	/*
	 * define a bean so that spring context could call from getBean
	 * In this case, call by function name
	 * + springContext.getBean("getGreatACBBank", ACBBank.class)
	 */
	@Bean
	public ACBBank getGreatACBBank() {
		System.out.println(" -> getGreatACBBank Bean in SpringConfiguration");
		
		ACBBank bank = new ACBBank("Great ACB Bank is create in @Configuration file");
		//bank.setMessage("Great ACB Bank is create in @Configuration file");
		
		return bank;
	}
	
	
	
	
	
}
