package com.omkar.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.omkar.ecommerce.entity.Cart;
import com.omkar.ecommerce.service.CartService;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:5173")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@GetMapping("/{userId}")
	public Cart getCart(@PathVariable Long userId) {
		return cartService.getCart(userId);
	}
	
	@PostMapping("/{userId}/add")
	public Cart addToCart(@PathVariable Long userId, @RequestParam Long productId, @RequestParam int quantity) {
		return cartService.addItemToCart(userId,productId,quantity);
	}
	
	@PutMapping("/{userId}/update/{cartItemId}")
	public Cart updateQuantity(@PathVariable Long userId, @PathVariable Long cartItemId,@RequestParam int quantity) {
		return cartService.updateItemQuantity(userId, cartItemId, quantity);
	}
	
	@DeleteMapping("/{userId}/remove/{cartItemId}")
	public Cart removeItemFromCart(@PathVariable Long userId, @PathVariable Long cartItemId) {
		return cartService.removeItemFromCart(userId, cartItemId);
	}
	
	

}
