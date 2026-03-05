package com.lpu.mobileApp.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, String>> getResourceNotFoundException(ResourceNotFoundException e){
		Map<String, String> map = new HashMap<>();
		map.put("error - ", e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		Map<String, String> map = new HashMap<>();
		map.put("error- ", e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, String>> handleAllExceptions(Exception e) {
		Map<String, String> map = new HashMap<>();
		map.put("error- ", e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}
}
