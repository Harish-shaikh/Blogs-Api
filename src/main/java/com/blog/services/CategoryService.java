package com.blog.services;

import java.util.List;

import com.blog.playloads.CategoryDto;

public interface CategoryService {
	
	//crateMethod
	CategoryDto createCategory(CategoryDto  categoryDto );
	//upadetMethod
	CategoryDto updateCategory(CategoryDto  categoryDto,Integer categoryId );
	//deleteMethod
	void deleteCategory(Integer categoryId );
	//getAllCategory
	List<CategoryDto> getAllCategory();
	//getSingaleCategoryMethod
	CategoryDto getCategoryById(Integer categoryId );
	

}
