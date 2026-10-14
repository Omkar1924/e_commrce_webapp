package com.omkar.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omkar.ecommerce.entity.*;
import com.omkar.ecommerce.exception.ResourceNotFoundException;
import com.omkar.ecommerce.repository.*;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private CartItemRepository cartItemRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserRepository userRepository;

	// Get cart or create cart for user

	public Cart getOrCreateCart(Long userID) {
		return cartRepository.findByUserId(userID).orElseGet(() -> {
			User user = userRepository.findById(userID)
					.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userID));
			Cart newCart = new Cart();
			newCart.setUser(user);
			return cartRepository.save(newCart);

		});
	}
	
	// Add product to the cart (or increase count if already exist )
	
	public Cart addItemToCart(Long userId, Long productId, int quntity) {
		Cart cart = getOrCreateCart(userId);
		
		Product product = productRepository.findById(productId)
				.orElseThrow(()->new ResourceNotFoundException("Product not found with id "+productId));
		
		CartItem existingItem = cart.getItems().stream()
				.filter(item -> item.getProduct().getId().equals(productId))
				.findFirst()
				.orElse(null);
		
		if(existingItem!=null) {
			existingItem.setQuantity(existingItem.getQuantity()+quntity);
		}else {
			CartItem newItem = new CartItem();
			newItem.setCart(cart);
			newItem.setProduct(product);
			newItem.setQuantity(quntity);
			cart.getItems().add(newItem);
		}
		
		return cartRepository.save(cart); 
		
	}
	
	//Update quantity of Specific item
	public Cart updateItemQuantity(Long userId, Long cartItemId, int quantity) {
		Cart cart = getOrCreateCart(userId);
		
		CartItem item=cart.getItems().stream()
				.filter(i -> i.getId().equals(cartItemId))
				.findFirst()
				.orElseThrow(() -> new ResourceNotFoundException("Cart item not found with ID :"+cartItemId));
		item.setQuantity(quantity);
		return cartRepository.save(cart);
	}
	
    // Remove an item from the cart
    public Cart removeItemFromCart(Long userId, Long cartItemId) {
        Cart cart = getOrCreateCart(userId);
        cart.getItems().removeIf(item -> item.getId().equals(cartItemId));
        return cartRepository.save(cart);
    }

    // View the cart
    public Cart getCart(Long userId) {
        return getOrCreateCart(userId);
    }

}
