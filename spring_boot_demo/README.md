Guide to build this project

1. Create spring boot project from eclipse

    File > New > Others > Spring Boot > **Spring Starter Project** (make sure eclipse was installed Spring Tool from eclipse market) > Select Spring web to import approriate dependencies.
    
    After the project is created, pom.xml [link](https://github.com/colenhuttran/spring-seftstudy/blob/master/spring_boot_demo/pom.xml) and SpringBootDemoApplication class [link](https://github.com/colenhuttran/spring-seftstudy/blob/master/spring_boot_demo/src/main/java/com/javalearning/spring_boot_demo/SpringBootDemoApplication.java) are created completely. 
    
2. Create Controllers to handle request from client (or web browser). [refer link](https://github.com/colenhuttran/spring-seftstudy/tree/master/spring_boot_demo/src/main/java/com/javalearning/spring_boot_demo/controller)

    In file [refer link](https://github.com/colenhuttran/spring-seftstudy/blob/master/spring_boot_demo/src/main/java/com/javalearning/spring_boot_demo/controller/GreetingControler.java)
    
    **@RestController** annotation tell Spring Boot that, this class is a controller, when a request send to Server, a default Servlet of spring 
    will be redirect it to the controller, and then the request will be handled by the controller.
    
    **@RequestMapping** annotation tell Spring Boot that, this function will handle url with format **"http://<websitename.com>/greeter/...",
    "http://<websitename.com>/greeter" or "http://<websitename.com>/say"**. All request from client with the same format will be send and handled
    in the function.
    
    **public Greeter greetingToClient(@PathVariable(required = false) String name)**, this function will return to client an object 
    Greeter in **JSON** format, SPRING BOOT do that automatically by using **jackson** lib.
    
    Beside that, **private GreeterRepository service = null;** with **@Autowired**, the annotation come from SPRING CORE, tell that 
    SPRING have to find GreeterRepository bean to inject on. Surely, GreeterRepository have to mark **Repository**
    
    That is done at back-end.
    
3. Keep on to create front-end [refer link](https://github.com/colenhuttran/spring-seftstudy/blob/master/spring_boot_demo/src/main/resources/static/hello-boot.html)

    Static resource have to create under **src/main/resources/static/** in SPRING BOOT.
    
    In **hello-boot.html**, we use an JQUERY to send request to Server, and processed by back-end (above Spring Boot, Controllers),
    then, get respone in front-end, then print it out.
    
    That is done at front-end.
    
4. Access http://localhost:8080/hello-boot.html, type your name and see the result
