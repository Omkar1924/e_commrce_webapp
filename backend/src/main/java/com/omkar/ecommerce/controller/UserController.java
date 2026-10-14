package com.omkar.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omkar.ecommerce.dto.LoginRequest;
import com.omkar.ecommerce.dto.SignupRequest;
import com.omkar.ecommerce.entity.User;
import com.omkar.ecommerce.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

	@Autowired
	 private UserService userService;
	
	@PostMapping("/signup")
	public User signup(@Valid @RequestBody SignupRequest request) {
		return userService.signup(request);
	}
	
	@PostMapping("/login")
	public User login(@Valid @RequestBody LoginRequest request) {
		return userService.login(request);
		
	}
}
