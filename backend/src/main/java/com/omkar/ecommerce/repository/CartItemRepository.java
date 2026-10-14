package com.omkar.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omkar.ecommerce.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
