package com.jags.tickets.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice 
@RestController 
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(TicketNotFoundException.class)
	public final ResponseEntity handleTicketNotFoundExcepiton(TicketNotFoundException ex, WebRequest request) {
		return new ResponseEntity("Ticket Not Found.", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity handleAllExceptions(Exception ex, WebRequest request) {
		return new ResponseEntity("Application Error.", HttpStatus.NOT_FOUND);
	}
	
}