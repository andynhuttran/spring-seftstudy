###There are some stuff you need to know about exception handling###

1. Throw exception at Service and Controller

2. Handle exception in class which extends **ResponseEntityExceptionHandler** and annotation **@ControllerAdvice**
[refer link](https://github.com/colenhuttran/spring-seftstudy/blob/master/restful_error_handling/src/main/java/com/javalearning/rest/exception/BaseException.java)

    Take a look to **ResponseEntityExceptionHandler** class, there are a lot functions to handle exceptions by default from SPRING BOOT.
    
    Each function in the class will handle an exception with annotation **@ExceptionHandler**. 
    For instance, 
    **@ExceptionHandler(Exception.class)** will handle all exceptions which is thrown with Exception class, 
    **@ExceptionHandler(PersonException.class)** will handle PersonException.
    
    Besides that, you could Override exsited handler in **ResponseEntityExceptionHandler** class. For instance, 
    **handleHttpMessageNotReadable** will handle bad body or empty body.
    
3. Class **ErrorApi** is created to define error content, then send it to client if exception happen.
Take a careful look in [this package](https://github.com/colenhuttran/spring-seftstudy/blob/master/restful_error_handling/src/main/java/com/javalearning/rest/exception)
