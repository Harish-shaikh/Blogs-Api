package com.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entities.Post;

public interface PostRepos extends JpaRepository<Post, Integer> {
	

}
