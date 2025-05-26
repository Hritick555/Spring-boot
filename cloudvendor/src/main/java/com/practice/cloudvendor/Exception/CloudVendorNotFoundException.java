package com.practice.cloudvendor.Exception;

public class CloudVendorNotFoundException extends RuntimeException{

	public CloudVendorNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CloudVendorNotFoundException(String message) {
		super(message);
	}
	
	

}
