package com.infy.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorMessage> handleValidationExceptions(MethodArgumentNotValidException ex){
		ErrorMessage error=new ErrorMessage();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
        error.setMessages(ex.getBindingResult().getFieldErrors().stream().map(err->err.getField()+":"+err.getDefaultMessage())
                                                              .collect(Collectors.toList()));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> handleGlobalExceptions(Exception ex){
		ErrorMessage error=new ErrorMessage();
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		List<String> messages=new ArrayList<String>();
		messages.add(ex.getMessage());
		error.setMessages(messages);
		return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
