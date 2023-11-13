package com.blog.exceptions;

import java.util.*;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blog.playloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptions {

@ExceptionHandler(ResourceNotFoundException .class)
  public ResponseEntity<ApiResponse> userResoureNotFoundExceptionHandler(ResourceNotFoundException ex){
	String message=ex.getMessage();
	 ApiResponse apiResouce=new  ApiResponse(message,false);
	
	return new ResponseEntity<ApiResponse>(apiResouce,HttpStatus.NOT_FOUND);
	
	  
  }

//@ExceptionHandler(MethodArgumentNotValidException.class)
//      public ResponseEntity<Map<String,String>> handelerMethodArgsNotValidException(MethodArgumentNotValidException ex){
//	Map<String, String> resp=new HashMap<>();
//	ex.getBindingResult().getAllErrors().forEach((error)->{
//		String filedName=((FieldError)error).getField();
//		String message=error.getDefaultMessage();
//		resp.put(filedName, message);
//	});
//	return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
//	
//}

}
