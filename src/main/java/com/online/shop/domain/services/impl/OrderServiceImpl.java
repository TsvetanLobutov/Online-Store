/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.shop.domain.services.impl;

import com.online.shop.domain.entities.Order;
import com.online.shop.domain.repositories.OrderRepository;
import com.online.shop.domain.services.OrderService;

/**
 *
 * @author tlobutov
 */
public class OrderServiceImpl implements OrderService{
    
    OrderRepository orderRepository;
    
    public OrderServiceImpl(){
        
        this.orderRepository = orderRepository;
        
    }

    @Override
    public Order createOrder(Order order) {
      
        return orderRepository.saveNewOrder(order);
        
    }

    @Override
    public Order getOrder(Long id) {
        return orderRepository.getOrder(id);
    }
    
}
