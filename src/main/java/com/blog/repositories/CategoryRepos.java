package com.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entities.Category;

public interface CategoryRepos  extends JpaRepository<Category, Integer>{

}
