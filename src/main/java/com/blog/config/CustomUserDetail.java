package com.blog.config;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.blog.entities.User;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.playloads.UserDto;
import com.blog.repositories.UserRepos;

@Service
public class CustomUserDetail implements UserDetailsService {
	
	
	
	@Autowired
    private UserRepos userRepos; 
  
 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
  
    	User user=this.userRepos.findByName(username);
  
        // Converting userDetail to UserDetails 
    	CustomUser customUser=new CustomUser(user);
        return customUser;
               
    } 
  
    public String addUser(User user) { 
        user.setPasswords(user.getPasswords()); 
        userRepos.save(user); 
        return "User Added Successfully"; 
    } 
//
//	@Autowired
//	private UserRepos userRepos;
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		//loading user from database by username
//		
//		User user=this.userRepos.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("User", "UserId"+username, 0));
//		return user;
//	}

}
