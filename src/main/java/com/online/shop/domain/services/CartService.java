/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.shop.domain.services;

import com.online.shop.domain.entities.Product;

/**
 *
 * @author tlobutov
 */
public interface CartService {
    
    void addProduct(Product product);
    void removeProductFromCart(Long id);
 //   void updateQuantity(String productId, Integer quantity);
    
    
    
    
}
