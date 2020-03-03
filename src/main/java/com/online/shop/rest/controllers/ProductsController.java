package com.online.shop.rest.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.shop.domain.entities.Product;
import com.online.shop.domain.services.ProductService;
import com.online.shop.rest.dto.ProductDTO;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {

        this.productService = productService;

    }

    @PostMapping()
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {

        Product product = productService.createProduct(productDTO.toEntity());

        return new ProductDTO(product);

    }

    @GetMapping("/{id}")
    public ProductDTO getProduct(@PathVariable Long id) {

        Product product = productService.getProduct(id);

        return new ProductDTO(product);

    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {

        Product product = productDTO.toEntity(id);
        product = productService.updateProduct(product);

        return new ProductDTO(product);

    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {

        productService.deleteProduct(id);

    }

    @GetMapping()
    public List<ProductDTO> searchProduct() {

        return productService.searchProducts().stream().map(ProductDTO::new).collect(Collectors.toList());
    }

}
