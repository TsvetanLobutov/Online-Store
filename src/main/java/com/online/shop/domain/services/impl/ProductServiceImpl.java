package com.online.shop.domain.services.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.shop.domain.entities.Product;
import com.online.shop.domain.repositories.ProductRepository;
import com.online.shop.domain.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {

        return productRepository.saveProduct(product);

    };

    public Product getProduct(Long id) {

        return productRepository.getProduct(id);

    };

    public Product updateProduct(Product product) {

        productRepository.getProduct(product.getId());

        BeanUtils.copyProperties(this, product);

        return productRepository.saveProduct(product);

    };

    public void deleteProduct(Long id) {

        productRepository.deleteProduct(id);

    };

    public List<Product> searchProducts() {

        return productRepository.searchProducts();

    }

    @Override
    public List<Product> getProducts(List<Long> ids) {
        
        return productRepository.getProducts(ids);
    };   
    
}
