package com.online.shop.domain.repositories;

import java.util.List;

import com.online.shop.domain.entities.Product;

public interface ProductRepository {
	
	Product saveProduct(Product product);

	Product getProduct(Long id);

	void deleteProduct(Long id);

	List<Product> searchProducts();
	
	List<Product> getProducts(List<Long> ids);

}
