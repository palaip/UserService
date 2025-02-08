package com.sample.user.userService.exception;

public class ResouceNotFoundException extends RuntimeException {

	private String message;
	
	public ResouceNotFoundException() {
		super();
	}
	
	public ResouceNotFoundException(String message) {
		super(message);
	}
	

}
