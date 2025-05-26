package com.practice.cloudvendor.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //To handle global exception
public class CloudVendorExceptionHandler {

	@ExceptionHandler(value = {CloudVendorNotFoundException.class})
	public ResponseEntity<Object> handleCloudVendorNotFoundException(CloudVendorNotFoundException cloudVendorNotFoundException){

		CloudVendorException cloudVendorException=new CloudVendorException(
				cloudVendorNotFoundException.getMessage(),
				cloudVendorNotFoundException.getCause(),
				HttpStatus.NOT_FOUND); //Will be displayed in response
		
		return new ResponseEntity<>(cloudVendorException, HttpStatus.NOT_FOUND);//Will be displayed at top of response
		
/*ResponseEntity is a generic class in Spring that represents an HTTP response, including:
       1. The HTTP status code
       2. Headers
       3. The response body

It allows you to fully customize the HTTP response returned by your controller methods.

Where Can ResponseEntity Be Used?

Regular Controller Methods:
---------------------------
You can use ResponseEntity in any controller method to return a custom HTTP response. For example:

@GetMapping("/example")
public ResponseEntity<String> example() {
    return ResponseEntity.ok("Hello, World!");
}

Exception Handler Methods:
-------------------------
ResponseEntity is commonly used in @ExceptionHandler methods to return custom error responses. 
For example:

@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
}

Anywhere You Need to Customize the HTTP Response:
You can use ResponseEntity in any method where you need to control the HTTP status, headers, or body of the response.

Example of ResponseEntity in a Controller
-----------------------------------------
@RestController
@RequestMapping("/api")
public class MyController {

    @GetMapping("/data")
    public ResponseEntity<MyData> getData() {
        MyData data = // fetch or create data
        return ResponseEntity.ok().header("Custom-Header", "value").body(data);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createData(@RequestBody MyData data) {
        // save data
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

Example of ResponseEntity in an Exception Handler
--------------------------------------------------
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}

Key Points:
-----------
ResponseEntity is not restricted to exception handlers.

It can be used anywhere you need to customize the HTTP response.

It provides flexibility in setting the status code, headers, and body of the response.

In summary, ResponseEntity is a powerful tool in Spring for crafting HTTP responses, and it can be used in a wide range of scenarios,
not just exception handling.
*/
	}
}
