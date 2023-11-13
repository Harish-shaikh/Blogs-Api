package com.blog.playloads;

public class ApiResponse {

	String message;
 boolean Sucess;
 //Contuctor
 public ApiResponse() {
	 
 }
 
 
 public ApiResponse(String message, boolean sucess) {
	super();
	this.message = message;
	Sucess = sucess;
}


//getter and setter
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public boolean isSucess() {
	return Sucess;
}
public void setSucess(boolean sucess) {
	Sucess = sucess;
}
 
}
