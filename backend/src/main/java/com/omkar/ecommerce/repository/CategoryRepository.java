package com.omkar.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omkar.ecommerce.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
