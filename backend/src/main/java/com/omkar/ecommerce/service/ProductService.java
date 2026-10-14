package com.omkar.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omkar.ecommerce.entity.Product;
import com.omkar.ecommerce.exception.ResourceNotFoundException;
import com.omkar.ecommerce.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts()
	{
		return productRepository.findAll();
	}
	
	public Product getProductById(Long id)
	{
		return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not find with ID : "+ id));
	}
	
	public Product createProduct(Product product)
	{
		return productRepository.save(product);
	}
	
	public Product updateProduct(Long id, Product updatedProduct)
	{
		Product existing = getProductById(id);
		existing.setName(updatedProduct.getName());
		existing.setDescription(updatedProduct.getDescription());
		existing.setPrice(updatedProduct.getPrice());
		existing.setStockQuantity(updatedProduct.getStockQuantity());
		existing.setImageUrl(updatedProduct.getImageUrl());
		existing.setCategory(updatedProduct.getCategory());
        return productRepository.save(existing);
	}
	
	public void deleteProduct(Long id)
	{
		productRepository.deleteById(id);
	}

}
