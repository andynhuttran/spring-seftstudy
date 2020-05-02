**Step to build this demo**

1. Under main package com.javalearning.rest create some pakages

    **model** : contains objects.
    
    **dao** : contains class used to get data from data source or data base (@Repository), then return result to services.
    
    **service** : contains class which call to DAO to get data and process data, then return to controller or api (@Service)
    
    **api** : contains controller or api to handle request from client, them call service to get data, and return to client. (@RestController)
    
    
2. Create Bank object in **model** package [refer link](https://github.com/colenhuttran/spring-seftstudy/blob/master/Restful_spring_boot/src/main/java/com/javalearning/rest/model/Bank.java). It is just a pojo class.

3. In **dao** package, create interface BankDAO and a class to implement the interface FakeBankDAO [refer link](https://github.com/colenhuttran/spring-seftstudy/tree/master/Restful_spring_boot/src/main/java/com/javalearning/rest/dao)

    Create interface to define which function which DAO layer will support. In case, we have many kinds of database or daa source, 
    defining interface helps changing data source fexibley. Now, we have no data source, so we make it faked or hard code in FakeBankDAO.
    When we have database Mysql to contain database, we change it to MysqlPersonDAO.
  
    In FakePersonDAO, let mark the class with @Repository("fakeDAO") annotation to tell 
    Spring BOOT that this class is a Bean, **fakeDAO**  called.
    
    We could get the bean **fakeDAO** by calling **springContext.getBean("fakeDAO")** or use **@Autowired** annotation.
    
    
4. In **service** package, create BankService class [refer link](https://github.com/colenhuttran/spring-seftstudy/tree/master/Restful_spring_boot/src/main/java/com/javalearning/rest/service)

    In the class, we call functions to get data from DAO by using **BankDAO**, the call functions to get data and process data,
    then return result is the main task of this layer.
    
    We have **@Autowired** annotation, in contructor, to tell that the beans instance of BankDAO should be enject this contructor.
    Actually it is FakeBankDAO which is marked above @Repository("fakeDAO"). Besides that, take a look to **@Qualifier("fakeDAO")** 
    tell SPRING that let inject (or set) BankDAO bean which called fakeDAO. If we have some beans in memory, using @Qualifier to select which 
    one is picked.
    
    Then, define functions which the service will provide, remember to mark the Service class with **@Service**, it is similar to **@Repository**
    to tell SPRING that, the is a bean, and we could get it from spring context or **@Autowired**.
    
5. In **api** package, create BankController class to handle request from client, and call **service** to get data. 
[refer link](https://github.com/colenhuttran/spring-seftstudy/tree/master/Restful_spring_boot/src/main/java/com/javalearning/rest/api)

    It is similar to **BankService** class, there is a constructor with **@Autowired** to get BankService bean, we have no @Qualifier 
    because we are sure that there is only one bean which instance of BankService in memory, we have no choise ^.^.
    
    Mark this class with **@RestController** annotation to tell SPRING that this is a controller to handle request from client.
    
    Take a look to **@RequestMapping("/api/v1/banks")**, it tell that URLs which contain format http://<your-web-sside>/api/v1/banks 
    will be handled by this controller. Example http://localhost:8080/api/v1/banks
    
    
    Go on to getBanks function with **@GetMapping** annotation, it tell SPRING BOOT that this function only accept Get request. In      additions, **@RequestParam(name = "top", required = false, defaultValue = "0")** paramater in url (e.x top=5) willint top be assiged to variable **int top**, it is not required, and default value is 0.
    
6. Then, take a look to exception handling in Spring Boot 
[refer link](https://github.com/colenhuttran/spring-seftstudy/tree/master/Restful_spring_boot/src/main/java/com/javalearning/rest/exception)

    It is very importance to handle exception and feedback to client, to know what the error is. Class **BaseExceptionHandler** with annotation **@ControllerAdvice** and extends **ResponseEntityExceptionHandler** tell that, this file will handle all exception in App.

   **@ExceptionHandler** and follow with a Exception class like Throwable.class, MethodArgumentTypeMismatchException.class, BankException.class tells that when there is error, it will be handled by the functions in the class. It's like a big try..catch of Application.
  
  
  



    

