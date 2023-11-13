package com.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entities.Category;
import com.blog.entities.User;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.playloads.CategoryDto;
import com.blog.playloads.UserDto;
import com.blog.repositories.CategoryRepos;
import com.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepos categoryRepos;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		 Category category=this.modelMapper.map(categoryDto,Category.class);
		 Category saveCategory=this.categoryRepos.save(category);

		return this.modelMapper.map(saveCategory,CategoryDto.class); 
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category category=this.categoryRepos.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","categoryId",categoryId));
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		
	  Category updateCategory=this.categoryRepos.save(category);
		
		return  this.modelMapper.map(updateCategory,CategoryDto.class); 
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category category=this.categoryRepos.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","categoryId",categoryId));
		this.categoryRepos.delete(category);
		
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> getAllCategory=this.categoryRepos.findAll();
		List<CategoryDto> categoryDto=getAllCategory.stream().map(category->this.modelMapper.map(category,CategoryDto.class)).collect(Collectors.toList());
	
		return categoryDto;
	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		Category category=this.categoryRepos.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","categoryId",categoryId));
		
		
		return this.modelMapper.map(category, CategoryDto.class);
	}

}
