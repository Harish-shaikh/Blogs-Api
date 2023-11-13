package com.blog.playloads;

public class CategoryDto {
	private int categoryId;
	private String categoryTitle;
	private String categoryDescription;

public CategoryDto() {
	
}

// argument construtor
public CategoryDto(int categoryId, String categoryTitle, String categoryDescription) {
	super();
	this.categoryId = categoryId;
	this.categoryTitle = categoryTitle;
	this.categoryDescription = categoryDescription;
}

//getter and  setter
public int getCategoryId() {
	return categoryId;
}

public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
}

public String getCategoryTitle() {
	return categoryTitle;
}

public void setCategoryTitle(String categoryTitle) {
	this.categoryTitle = categoryTitle;
}

public String getCategoryDescription() {
	return categoryDescription;
}

public void setCategoryDescription(String categoryDescription) {
	this.categoryDescription = categoryDescription;
}



}
