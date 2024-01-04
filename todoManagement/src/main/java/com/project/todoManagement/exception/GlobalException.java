package com.project.todoManagement.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ExceptionHandler(ResourceNotFoundException.class)
	private ResponseEntity<ErrorDetails> handleEmailNotFoundException(ResourceNotFoundException resourceNotFoundException, WebRequest webRequest){
		
		ErrorDetails errorDetails = new ErrorDetails(
				
				LocalDateTime.now(),
				resourceNotFoundException.getMessage(),
				webRequest.getDescription(false),
				"EMAIL_ALREADY_EXISTS"

				
				);
		
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	private ResponseEntity<ErrorDetails> handleException(Exception exception, WebRequest webRequest){
		
		ErrorDetails errorDetails = new ErrorDetails(
				
				LocalDateTime.now(),
				exception.getMessage(),
				webRequest.getDescription(false),
				"INTERNAL_SERVER_ERROR"

				
				);
		
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	

}
