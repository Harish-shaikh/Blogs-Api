package com.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.playloads.ApiResponse;
import com.blog.playloads.CategoryDto;
import com.blog.services.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	//createCatagory
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
		CategoryDto saveCategoryDto=this.categoryService.createCategory(categoryDto);
		
		return new ResponseEntity<>(saveCategoryDto,HttpStatus.CREATED);
		
	}
	//updateCategory
	@PutMapping("/update/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@PathVariable("categoryId") Integer categoryId,@RequestBody CategoryDto categoryDto){
		CategoryDto updateCategory=this.categoryService.updateCategory(categoryDto, categoryId);
		
		 return new ResponseEntity<CategoryDto>(updateCategory,HttpStatus.OK);
	}
	//deleteCategory
	@DeleteMapping("/delete/{categoryId}")
	public ResponseEntity<?> deleteCategory(@PathVariable("categoryId") Integer categoryId){
		 this.categoryService.deleteCategory(categoryId);
		  ApiResponse apiResponse=new ApiResponse("category is deleteed",true);
		 return new ResponseEntity<>(apiResponse,HttpStatus.OK);
	}
	
	//getcatogry
	@GetMapping("/get/{categoryId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable("categoryId") Integer categoryId){
		CategoryDto categoryDto=this.categoryService.getCategoryById(categoryId);
		
		return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
	}
	//getAllCategory
	@GetMapping("/getAll")
	public ResponseEntity<List<CategoryDto>> getAllCategory(){
		return ResponseEntity.ok(this.categoryService.getAllCategory()); 
	}

}
