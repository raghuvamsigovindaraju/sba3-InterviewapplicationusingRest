package com.wellsfargo.fsd.interview.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.fsd.interview.exception.ContactException;

@RestControllerAdvice
public class GlobalExceptionController {
	
	@ExceptionHandler(ContactException.class)
	public ResponseEntity<String> handleContactException(ContactException exp) {
		
		return new ResponseEntity<String>(exp.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(ContactException exp) {
		
		return new ResponseEntity<String>(exp.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

}