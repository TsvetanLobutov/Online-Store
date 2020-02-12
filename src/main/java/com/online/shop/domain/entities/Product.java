package com.online.shop.domain.entities;

import java.math.BigDecimal;

import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "products")
public class Product {

	private Long id;

	private String title;

	private String description;

	private BigDecimal price;

}
