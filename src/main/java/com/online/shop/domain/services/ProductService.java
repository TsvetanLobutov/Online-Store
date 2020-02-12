package com.online.shop.domain.services;

import java.util.List;

import com.online.shop.domain.entities.Product;

public interface ProductService {

	public Product createProduct(Product product);

	public Product getProduct(Long id);

	public Product updateProduct(Product productDTO);

	public void deleteProduct();

	public List<Product> searchProduct();

}
