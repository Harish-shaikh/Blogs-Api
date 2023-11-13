package com.blog.controllers;

import java.util.List;



import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.playloads.UserDto;
import com.blog.security.JwtService;
import com.blog.entities.AuthRequest;
import com.blog.playloads.ApiResponse;
import com.blog.services.UserService;



@RestController
@RequestMapping("/api/users")
public class UserControllers {
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
    private AuthenticationManager authenticationManager; 

	//post create user
	@PostMapping("/p")
	public ResponseEntity<UserDto> createUser( @RequestBody UserDto userDto){
		UserDto createUserDto=this.userService.createUser(userDto);
		
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
	}
	//put-update user
	@PutMapping("/update/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable("userId") Integer uId){
		UserDto updateUsers=this.userService.updateUser(userDto, uId);
		return new ResponseEntity<>(updateUsers,HttpStatus.OK);
	}
	//Delete- deleteUser
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer uId){
		this.userService.deleteUser(uId);
		ApiResponse apiResponse=new ApiResponse("user deleted",true);
		
		
		return new ResponseEntity<>(apiResponse,HttpStatus.OK);
	}
	
	//get    -user get
	@GetMapping("/getUsers")
	public ResponseEntity<List<UserDto>> getUsers(){
		return ResponseEntity.ok(this.userService.getAllUser()); 
	}
	@GetMapping("/getUsers/{userId}")
	public ResponseEntity<UserDto> getSingleUsers(@PathVariable("userId") Integer uId){
		return ResponseEntity.ok(this.userService.getUserById(uId)); 
	}
	// this is for authentication of user
	
	 @PostMapping("/generateToken") 
	    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) { 
	        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())); 
	        if (authentication.isAuthenticated()) { 
	            return jwtService.generateToken(authRequest.getUsername()); 
	        } else { 
	            throw new UsernameNotFoundException("invalid user request !"); 
	        } 
	    } 
	
	

}
