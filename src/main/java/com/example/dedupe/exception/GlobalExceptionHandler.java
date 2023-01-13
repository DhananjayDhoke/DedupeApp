package com.example.dedupe.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<CustmizeErrorDetails> resourceNotFoundExceptionHandler(Exception e,WebRequest req) {
		CustmizeErrorDetails err=new CustmizeErrorDetails(LocalDateTime.now(), e.getMessage(), req.getDescription(false));
	return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustmizeErrorDetails> exceptionHandler(Exception e,WebRequest req) {
		CustmizeErrorDetails err=new CustmizeErrorDetails(LocalDateTime.now(), e.getMessage(), req.getDescription(false));
	return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
}

