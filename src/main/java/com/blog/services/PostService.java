package com.blog.services;

import java.util.List;

import com.blog.entities.Post;
import com.blog.playloads.PostDto;

public interface PostService {
	

	//create
	PostDto CreatePost(PostDto postDto,Integer userId,Integer categoryId);
	//update
	PostDto updatePost(PostDto postDto,Integer postId);
	//delete
	void deletePost(Integer postId);
	//getAllpost
	List<PostDto> getAllPost();
	//get Signle Post
	PostDto getPostById(Integer postId);
	//get Post by category
	List<PostDto> getCategoryById(Integer categoryId);
	//get post by user
	List<PostDto> getUserById(Integer userId);
	//search post
	List<PostDto> SearchPost(String keyword);
	
	
}
