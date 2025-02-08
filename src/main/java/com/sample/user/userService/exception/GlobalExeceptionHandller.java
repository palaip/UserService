package com.sample.user.userService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sample.user.userService.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExeceptionHandller {

	@ExceptionHandler(ResouceNotFoundException.class)

	public ResponseEntity<ApiResponse> resourceNotFoundHandler(ResouceNotFoundException ex) {

		ApiResponse apiResponse = ApiResponse.builder().message(ex.getMessage()).success(false).status(HttpStatus.NOT_FOUND).build();

		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(ResourceAlreadyExist.class)
	public ResponseEntity<ApiResponse> resouceAlreadyExist(ResourceAlreadyExist ex) {

		ApiResponse apiResponse = ApiResponse.builder().message(ex.getMessage()).success(false).status(HttpStatus.CONFLICT).build();
		
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.CONFLICT);

	}

}
