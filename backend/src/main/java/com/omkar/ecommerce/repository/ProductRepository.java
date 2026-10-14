package com.omkar.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omkar.ecommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
