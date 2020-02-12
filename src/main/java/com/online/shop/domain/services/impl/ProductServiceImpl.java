package com.online.shop.domain.services.impl;

import java.util.List;

import com.online.shop.domain.entities.Product;
import com.online.shop.domain.repositories.ProductRepository;
import com.online.shop.domain.services.ProductService;
import com.online.shop.rest.controllers.ProductsController;

public class ProductServiceImpl implements ProductService{
	
	ProductRepository productRepository;
	
	public Product createProduct(Product product) {
		
	 
		
	};

	public Product getProduct(Long id);

	public Product updateProduct(Product productDTO);

	public void deleteProduct();

	public List<Product> searchProduct();
	
	

}
