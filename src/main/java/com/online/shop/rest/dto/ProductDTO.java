package com.online.shop.rest.dto;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;

import com.online.shop.domain.entities.Product;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDTO {

	private Long id;

	private String title;

	private String description;

	private double price;

	public ProductDTO(Product product) {

		BeanUtils.copyProperties(product, this);

		this.price = product.getPrice().doubleValue();

	}

	public Product toProduct() {

		Product product = new Product();

		BeanUtils.copyProperties(this, product);

		product.setPrice(BigDecimal.valueOf(this.price));

		return product;
	}

	public Product toEntity(Long id) {

		Product product = this.toProduct();

		product.setId(id);

		return product;
	}

}
