package com.wellsfargo.fsd.interview.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.wellsfargo.fsd.interview.exception.InterviewException;
import com.wellsfargo.fsd.interview.exception.UserException;

@RestControllerAdvice
public class GlobalExceptionController {
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<String> handleUSerException(UserException exp) {
		
		return new ResponseEntity<String>(exp.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGenericUserException(UserException exp) {
		
		return new ResponseEntity<String>(exp.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(InterviewException.class)
	public ResponseEntity<String> handleInterviewException(InterviewException exp) {
		
		return new ResponseEntity<String>(exp.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	/*
	 * @ExceptionHandler(Exception.class) public ResponseEntity<String>
	 * handleGenericInterviewException(InterviewException exp) {
	 * 
	 * return new
	 * ResponseEntity<String>(exp.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR); }
	 */

}
