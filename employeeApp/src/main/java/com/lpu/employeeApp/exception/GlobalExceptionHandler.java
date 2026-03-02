package com.lpu.employeeApp.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<Map<String, String>> handleArithmeticExcep(ArithmeticException excep){
		Map<String, String> map = new HashMap<String, String>();
		map.put("Error", excep.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
	}
	
	@ExceptionHandler(CompanyNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleCompanyNotFoundExcep(CompanyNotFoundException excep) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("Error", excep.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleEmployeeNotFoundExcep(EmployeeNotFoundException excep) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("Error", excep.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}
	
	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<Map<String, String>> handleNoDataFoundExcep(NoDataFoundException excep) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("Error", excep.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidExcep(MethodArgumentNotValidException excep) {
		Map<String, String> map = new HashMap<String, String>();
		
		excep.getBindingResult().getFieldErrors().forEach(error -> map.put(error.getField(), error.getDefaultMessage()));
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}
	
	@ExceptionHandler(Exception.class)
	public Map<String, String> handleAllException(Exception excep){
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("error", excep.getMessage());
		
		return map;
	}
}
