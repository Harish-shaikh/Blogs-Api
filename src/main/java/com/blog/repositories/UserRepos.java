package com.blog.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entities.User;

public interface UserRepos extends JpaRepository<User,Integer> {
	
	User findByName(String username); 

}
