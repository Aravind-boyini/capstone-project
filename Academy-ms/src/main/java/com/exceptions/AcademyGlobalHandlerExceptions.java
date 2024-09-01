package com.exceptions;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@RestControllerAdvice
public class AcademyGlobalHandlerExceptions {
	
	

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<String> handleAllExceptions(Exception ex) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("An unexpected error occurred: " + ex.getMessage());
	    }  
/*
	    @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                .body(ex.getMessage());
	    }
	
     */
	    @ExceptionHandler(CustomException.class)
	    public ResponseEntity<ErrorResponse> handleCustomException(CustomException ex) {
	        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
	        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	    }
}
