# Step to do implement this project

1. Add spring-core and spring-context to pom.xml

2. Create IBank interface, then implement the interface with ACBBank and VNBank [refer link](https://github.com/colenhuttran/spring-seftstudy/tree/master/spring_bean_annotation/src/main/java/com/javalearning/spring_bean_annotation/components)
 
    Add annotation **@Component** to implementation class in order to tell spring that, it is bean, and the class will be initial after spring context is loaded
 
3. Create configuration class [refer link](https://github.com/colenhuttran/spring-seftstudy/blob/master/spring_bean_annotation/src/main/java/com/javalearning/spring_bean_annotation/SpringConfiguration.java)

    Add annotation **@Configuration** to tell spring that this file is main configuration for spring.
    
    Annotation **@ComponentScan** tell the packages contain bean which spring could be scan out.
    
    Create a function getGreatACBBank() with annotation **@Bean**, to tell that sping context could call to create Bean.
    
4. Create Services class [refer link](https://github.com/colenhuttran/spring-seftstudy/tree/master/spring_bean_annotation/src/main/java/com/javalearning/spring_bean_annotation/services)

    This class is marked with **@Service("bankService")**, it is a bean, and can be called via spring context, with the bean name is "bankService"

    In BankServiceImp [link](https://github.com/colenhuttran/spring-seftstudy/blob/master/spring_bean_annotation/src/main/java/com/javalearning/spring_bean_annotation/services/BankServiceImp.java)
    creates with **@Autowired** annotation, the functions will called automatically when spring context is loaded.
    
 5. Create MainApp class [link](https://github.com/colenhuttran/spring-seftstudy/blob/master/spring_bean_annotation/src/main/java/com/javalearning/spring_bean_annotation/MainApp.java)
 
    In the main class, spring context is created by **AnnotationConfigApplicationContext**, when the context is loaded, bean with above annotations is called or created as well.
    write to constructors or top of function to know more detail/
    
    After geting spring context, we could create bean by method getBean. 
    
    Bean is java objects which is loaded from spring context, ater getting the beans, we could call their functions as Java object
