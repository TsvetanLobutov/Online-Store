/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.shop.rest.controllers;

import com.online.shop.domain.entities.Order;
import com.online.shop.domain.services.OrderService;
import com.online.shop.rest.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tlobutov
 */

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private final OrderService orderService;
    
    @Autowired
    public OrdersController(OrderService orderService1){
        
        this.orderService = orderService1;
        
    }
    
    @PostMapping
    public OrderDTO createOrder(OrderDTO orderDTO){
        
        Order order = orderService.createOrder(orderDTO.toOrder());
        
        return new OrderDTO(order);
        
    }
    
    
    
    
}
