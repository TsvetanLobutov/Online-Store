package com.online.shop.domain.repositories.springdata;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.online.shop.domain.entities.Product;

public interface ProductRepositorySD extends CrudRepository<Product, Long> {
    
    List<Product> findAll();

}
