package com.omkar.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omkar.ecommerce.entity.Category;
import com.omkar.ecommerce.service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:5173")

public class CategoryController {
	
	@Autowired
	private CategoryService categoryServices;
	
	@GetMapping
	public List<Category> getALLCategoris(){
		return categoryServices.getAllCategory();
	}
	
	@GetMapping("/{id}")
	public Category getCategoryById(@PathVariable Long id) {
		return categoryServices.getCategoryById(id);
	}
	
	@PostMapping
	public Category createCategory(@RequestBody @Valid Category category) {
		return categoryServices.createCategory(category);
	}
	
	@PutMapping("/{id}")
	public Category updateCategory(@PathVariable Long id, @RequestBody @Valid Category category) {
		return categoryServices.updateCategory(id, category);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable Long id) {
		categoryServices.deleteCategory(id);
	}

}
