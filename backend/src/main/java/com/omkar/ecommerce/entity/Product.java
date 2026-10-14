package com.omkar.ecommerce.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "products")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message ="Product Name is Required")
	@Column(nullable = false)
	private String name;
	
	private String description;
	
	@NotNull(message = "Price is Required")
	@DecimalMin(value = "0.0", inclusive = false, message = "Price must greater then 0")
	@Column(nullable = false)
	private BigDecimal price;
	
	@Min(value = 0, message = "Stock quantity can not be negative")
	private int stockQuantity;
	
	private String imageUrl;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	

}
