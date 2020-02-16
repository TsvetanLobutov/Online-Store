package com.online.shop.persistence.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.shop.domain.entities.Product;
import com.online.shop.domain.exceptions.ResourceNotFoundExeption;
import com.online.shop.domain.repositories.ProductRepository;
import com.online.shop.domain.repositories.springdata.ProductRepositorySD;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductRepositorySD productRepositorySD;

    @Autowired
    public ProductRepositoryImpl(ProductRepositorySD productRepositorySD) {
        this.productRepositorySD = productRepositorySD;
    }

    @Override
    public Product saveProduct(Product product) {

        return productRepositorySD.save(product);

    }

    @Override
    public Product getProduct(Long id) {

        return productRepositorySD.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExeption("Product with ID: " + id + " does not exist"));
    }

    @Override
    public void deleteProduct(Long id) {

        productRepositorySD.deleteById(id);

    }

    @Override
    public List<Product> searchProducts() {
        
        return productRepositorySD.findAll();
        
    }

}
