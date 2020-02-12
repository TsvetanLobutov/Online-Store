package com.online.shop.domain.entities;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "orders")
public class Order {
	
	private Long id;
	
	private List<Product> products;
	
	private String customerFirstName;
	
	private String customerLastName;
	
	private BigDecimal totalPrice;
	

}
