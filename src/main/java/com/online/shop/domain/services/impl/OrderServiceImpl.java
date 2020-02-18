/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.shop.domain.services.impl;

import com.online.shop.domain.entities.Order;
import com.online.shop.domain.enums.OrderSatatusEnum;
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
        
        order.setOrderStatus(OrderSatatusEnum.FINISHED.getCode());
      
        return orderRepository.saveOrder(order);
        
    }

    @Override
    public Order getOrder(Long id) {
        return orderRepository.getOrder(id);
    }



    @Override
    public void cancelOrder(Long id) {
     
        Order order = orderRepository.getOrder(id);
        
        order.setOrderStatus(OrderSatatusEnum.CANCELED.getCode());
        orderRepository.saveOrder(order);
        
    }
    
    
    
}
