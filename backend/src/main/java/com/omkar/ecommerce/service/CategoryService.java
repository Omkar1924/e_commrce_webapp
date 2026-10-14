package com.omkar.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omkar.ecommerce.entity.Category;
import com.omkar.ecommerce.exception.ResourceNotFoundException;
import com.omkar.ecommerce.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> getAllCategory() {
		return categoryRepository.findAll();
	}

	public Category getCategoryById(Long id) {

		return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found by id :"+ id));
	}
	
	public Category createCategory(Category createCategory) {
		return categoryRepository.save(createCategory);
	}
	
	public Category updateCategory(Long id, Category updateCategory) {
		Category existing = getCategoryById(id);
		existing.setName(updateCategory.getName());
		existing.setDescription(updateCategory.getDescription());
		return categoryRepository.save(existing);
	}
	
	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}

}
