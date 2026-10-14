package com.omkar.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.omkar.ecommerce.dto.LoginRequest;
import com.omkar.ecommerce.dto.SignupRequest;
import com.omkar.ecommerce.entity.Role;
import com.omkar.ecommerce.entity.User;
import com.omkar.ecommerce.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User signup(SignupRequest request) {
		if(userRepository.findByEmail(request.getEmail()).isPresent()) {
			throw new IllegalArgumentException("Email already register");
		}
		
		User user = new User();
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setRole(Role.CUSTOMER);
		
		return userRepository.save(user);
	}
	
	public User login(LoginRequest request) {
		
		User user = userRepository.findByEmail(request.getEmail())
				.orElseThrow(()-> new IllegalArgumentException("Invalid Email or Password"));
		
	    System.out.println("Found user: " + user.getEmail());
	    System.out.println("Stored hash: " + user.getPassword());
	    System.out.println("Raw password sent: " + request.getPassword());
		
		if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
			throw new IllegalArgumentException("Invalid email or password");
		}
		
		return user;
	}
}
