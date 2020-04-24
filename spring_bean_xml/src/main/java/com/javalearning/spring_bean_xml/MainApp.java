package com.javalearning.spring_bean_xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("beans.xml");
		
		HelloSpringCore helloSpringCore = springContext.getBean("beanHelloId", HelloSpringCore.class);
		String str = helloSpringCore.buildToString();
		System.out.println(str);
		
		HelloSpringCore bean = springContext.getBean("myBean", HelloSpringCore.class);
		str = bean.buildToString();
		System.out.println(str);
		
		
		springContext.close();
	}
}
