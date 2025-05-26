package com.practice.cloudvendor.Exception;

import org.springframework.http.HttpStatus;

public class CloudVendorException {
	
	private final String message;
	private final Throwable throwable;// This will be used to get all the error message stack. To use this we need to write catch block
	private final HttpStatus httpstatus;
	
	public String getMessage() {
		return message;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public HttpStatus getHttpstatus() {
		return httpstatus;
	}

	public CloudVendorException(String message, Throwable throwable, HttpStatus httpstatus) {
		super();
		this.message = message;
		this.throwable = throwable;
		this.httpstatus = httpstatus;
	}
	
	

}
