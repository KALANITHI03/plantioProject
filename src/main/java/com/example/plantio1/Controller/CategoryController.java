package com.example.plantio1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.plantio1.Entity.Category;
import com.example.plantio1.Services.CategoryServices;

@RestController
public class CategoryController {
	
	@Autowired
	CategoryServices categoryServices;

	@PostMapping("/addCategory")
	public void addCategory(@RequestBody Category category) {
	 categoryServices.addCategory(category);	
	}
	
	@GetMapping("/getAllCategory")
	public List<Category> getAll() {
		return categoryServices.getAll();
	}
	
	@GetMapping("/getByCId/{id}")
	public Category getById(@PathVariable long id) {
		return categoryServices.getById(id);
	}
}
