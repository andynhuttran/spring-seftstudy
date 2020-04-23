# Steps to build this project

1.Add dependencies to pom.xml [refer link](https://github.com/colenhuttran/spring-seftstudy/blob/master/spring_bean_xml/pom.xml)

		spring-core and spring-context
	
2.Create HelloSpringCore class [refer link](https://github.com/colenhuttran/spring-seftstudy/blob/master/spring_bean_xml/src/main/java/com/javalearning/spring_bean_xml/HelloSpringCore.java)

		it contains a constructor, property "name", and a function buildToString
		constructor, and property will be called to create bean (an object)
		
3.Create beans.xml in src\main\resources folder [refer link](https://github.com/colenhuttran/spring-seftstudy/blob/master/spring_bean_xml/src/main/resources/beans.xml)

		Define object by using tag <bean> in beans.xml.
		Create 2 object by define id, class, constructor + parameters, and property

4. Create MainApp class to create context by loading beans.xml file, then get beans by id. [refer link](https://github.com/colenhuttran/spring-seftstudy/blob/master/spring_bean_xml/src/main/java/com/javalearning/spring_bean_xml/MainApp.java)
