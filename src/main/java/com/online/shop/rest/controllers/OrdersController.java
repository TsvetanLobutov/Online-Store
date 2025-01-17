/*
  * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.shop.rest.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.shop.domain.entities.Order;
import com.online.shop.domain.entities.OrderItem;
import com.online.shop.domain.entities.Product;
import com.online.shop.domain.services.OrderService;
import com.online.shop.rest.dto.OrderDTO;
import com.online.shop.rest.dto.OrderDetailsDTO;

/**
 *
 * @author tlobutov
 */

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private final OrderService orderService;

    @Autowired
    public OrdersController(OrderService orderService1) {

        this.orderService = orderService1;

    }

    @PostMapping
    public OrderDetailsDTO createOrder(@RequestBody OrderDetailsDTO orderDetailsDTO) {

        Order order = orderService.createOrder(orderDetailsDTO.toEntity());

        return new OrderDetailsDTO(order);

    }

    @GetMapping("/{id}")
    public OrderDetailsDTO getOrder(@PathVariable Long id) {

        Order order = orderService.getOrder(id);

        return new OrderDetailsDTO(order);

    }

    @PostMapping("{id}/cancel")
    public String cancel(@PathVariable Long id) {

        Order order = orderService.getOrder(id);

        orderService.cancelOrder(order.getId());

        return "redirect:" + "";
    }

    @GetMapping()
    public List<OrderDTO> searchOrder() {

        List<OrderDTO> orders = orderService.searchOrders().stream().map(OrderDTO::new).collect(Collectors.toList());
        return orders;
    }

}
