package com.blog.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entities.Category;
import com.blog.entities.Post;
import com.blog.entities.User;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.playloads.PostDto;
import com.blog.repositories.CategoryRepos;
import com.blog.repositories.PostRepos;
import com.blog.repositories.UserRepos;
import com.blog.services.PostService;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepos postRepos;
	
	@Autowired
	private UserRepos userRepos;
	
	@Autowired
	private CategoryRepos categoryRepos;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	

	@Override
	public PostDto CreatePost(PostDto postDto,Integer userId,Integer categoryId) {
		User user=this.userRepos.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "UserID", userId));
		Category category=this.categoryRepos.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "CategoryID", categoryId));
		
		Post post=this.modelMapper.map(postDto,Post.class);
		post.setAddDate(new Date());
		post.setImageName("deafult.png");
		post.setUser(user);
		post.setCategory(category);
		Post savePost=this.postRepos.save(post);
		
		
		return this.modelMapper.map(savePost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PostDto> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getCategoryById(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> SearchPost(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
