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

import com.omkar.ecommerce.entity.Product;
import com.omkar.ecommerce.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public List<Product> getAllProducts()
	{
		return productService.getAllProducts();
	}

	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id)
	{
		return productService.getProductById(id);
	}
	
	@PostMapping
	public Product createProduct(@Valid @RequestBody Product product)
	{
		return productService.createProduct(product);
	}
	
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Long id, @Valid @RequestBody Product product)
	{
		return productService.updateProduct(id, product);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id)
	{
		productService.deleteProduct(id);
	}
}
