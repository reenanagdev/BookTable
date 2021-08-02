package com.keito.booktable.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ReservationExceptionController {
	
	@ExceptionHandler(value = IllegalStateException.class)
	   public ResponseEntity<Object> exception(IllegalStateException exception) {
	      return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	   }

}
