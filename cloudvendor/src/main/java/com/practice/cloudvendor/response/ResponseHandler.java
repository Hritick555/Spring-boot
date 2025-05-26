package com.practice.cloudvendor.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler { // This class is used to write custom responses to our code

	public static ResponseEntity<Object> responseBuilder( // Used Static method cause no need of object creation in
															// controller return statement
			// If we return as return ResponseHandler.responseBuilder() in controller class,
			// then no need of static method here
			String message, HttpStatus httpstatus, Object responseObject) {
		Map<String, Object> response = new HashMap<>();
		response.put("message", message);
		response.put("httpStatus", httpstatus);
		response.put("data", responseObject);

		return new ResponseEntity<>(response, httpstatus);

	}

	public static ResponseEntity<Object> responseBuilderForPhone(String message, Object responseObject,
			HttpStatus httpstatus) {
		Map<String, Object> response = new HashMap<>();
		response.put("message", message);
		response.put("httpStatus", httpstatus);
		response.put("result", responseObject);

		return new ResponseEntity<>(response, httpstatus);
	}

	{

	}

}
