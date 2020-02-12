package com.online.shop.rest.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.online.shop.domain.entities.Product;
import com.online.shop.domain.services.ProductService;
import com.online.shop.rest.dto.ProductDTO;

public class ProductsController {

	private final ProductService productService;

	@Autowired
	public ProductsController(ProductService productService) {

		this.productService = productService;

	}

	public ProductDTO createProduct(ProductDTO productDTO) {

		Product product = productService.createProduct(productDTO.toProduct());

		return new ProductDTO(product);

	}

	public ProductDTO getProduct(Long id) {

		Product product = productService.getProduct(id);

		return new ProductDTO(product);

	}

	public ProductDTO updateProduct(ProductDTO productDTO) {

		Product product = productService.updateProduct(productDTO.toProduct());

		return new ProductDTO(product);

	}

	public void deleteProduct() {

		productService.deleteProduct();

	}

	public List<ProductDTO> searchProduct() {

		return productService.searchProduct().stream()
				.map(ProductDTO::new)
				.collect(Collectors.toList());
	}

}
