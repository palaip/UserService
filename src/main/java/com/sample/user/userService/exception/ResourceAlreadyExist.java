package com.sample.user.userService.exception;

public class ResourceAlreadyExist extends RuntimeException {

	private String message;

	public ResourceAlreadyExist(String message) {
		super(message);
		this.message = message;
	}

	public ResourceAlreadyExist() {
		super();
	}
}
