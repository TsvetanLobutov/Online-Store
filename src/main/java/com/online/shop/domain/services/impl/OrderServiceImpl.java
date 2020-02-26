/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.shop.domain.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.online.shop.domain.entities.Order;
import com.online.shop.domain.enums.OrderStatus;
import com.online.shop.domain.repositories.OrderRepository;
import com.online.shop.domain.services.OrderService;

/**
 *
 * @author tlobutov
 */
@Service
public class OrderServiceImpl implements OrderService{
    
    OrderRepository orderRepository;
    
    public OrderServiceImpl(OrderRepository orderRepository){
        
        this.orderRepository = orderRepository;
        
    }

    @Override
    public Order createOrder(Order order) {
        
        order.setOrderStatus(OrderStatus.CREATED);
      
        return orderRepository.saveOrder(order);
        
    }

    @Override
    public Order getOrder(Long id) {
        return orderRepository.getOrder(id);
    }



    @Override
    public void cancelOrder(Long id) {
     
        Order order = orderRepository.getOrder(id);
        
        order.setOrderStatus(OrderStatus.CANCELED);
        orderRepository.saveOrder(order);
        
    }
    
    @Override
    public List<Order> searchOrders() {

        return orderRepository.searchOrders();

    };
    
    
    
}
