package com.validation.restapi.app.exception;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandeller {
	

	@ExceptionHandler(UserNotFoundExcetion.class)
	public ResponseEntity<APIErrors> handllerUserNotFoundExcetion(UserNotFoundExcetion e, HttpServletRequest req){
	System.out.println("Handle");
	
	APIErrors error =new APIErrors();
	error.setDate(new Date());
	error.setStatuscode(HttpStatus.NOT_FOUND.value());
	error.setMessage(e.getMessage());
	error.setPath(req.getRequestURI());
	error.setHttpMessage(HttpStatus.NOT_FOUND);
	
	
		return new ResponseEntity<APIErrors>(error,  HttpStatus.NOT_FOUND);
	}
	
    @ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
		Map<String, String> map=new HashMap<>();
		e.getBindingResult().getAllErrors().forEach((error)->{
			String value = error.getDefaultMessage();
		String key = ((FieldError) error).getField();
		map.put(key, value);
		});
		
		return new ResponseEntity<Map<String,String>>(map, HttpStatus.BAD_REQUEST);
	}
}
