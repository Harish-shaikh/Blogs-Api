package com.blog.playloads;

import java.util.Date;

import com.blog.entities.Category;
import com.blog.entities.User;

public class PostDto {
	
	private String title;
	private String content;
	private String imageName;
	private Date addDate;
	private Category category;
	private User user;
	
	public PostDto() {
		
	}
	
//	Getter and Setter
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}
