package com.example.plantio1.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.plantio1.Entity.Category;
import com.example.plantio1.Repository.CategoryRepository;

@Service
public class CategoryServices {
	
	@Autowired
	CategoryRepository categoryRepository;

	public void addCategory(Category category) {
		categoryRepository.save(category);
	}
	
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}
	
	public Category getById(long id) {
		return categoryRepository.getReferenceById(id);
	}
}
