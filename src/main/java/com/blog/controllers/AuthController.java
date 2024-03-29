//package com.blog.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.blog.security.JwtAuthRequest;
//import com.blog.security.JwtAuthResponse;
//import com.blog.security.JwtTokenHelper;
//
//@RestController
//@RequestMapping("/api/v1/auth")
//public class AuthController {
//	@Autowired
//	private JwtTokenHelper jwtTokenHelper;
//	@Autowired
//	private UserDetailsService userDetailsService;
//	@Autowired
//	private AuthenticationManager authenticationManager;
//
//	@PostMapping("/login")
//	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest jwtAuthRequest){
//		
//		this.authenticate(jwtAuthRequest.getUsername(),jwtAuthRequest.getPassword());
//		UserDetails userDetails=this.userDetailsService.loadUserByUsername(jwtAuthRequest.getUsername());
//		String token=this.jwtTokenHelper.generateToken(userDetails);
//		JwtAuthResponse response=new JwtAuthResponse();
//		response.setToken(token);
//		return new ResponseEntity<JwtAuthResponse>(response,HttpStatus.OK);
//	}
//	
//	private void authenticate(String username,String Password) {
//		UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(username, Password);
//		this.authenticationManager.authenticate(authenticationToken);
//	}
//}
