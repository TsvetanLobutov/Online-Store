/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.shop.domain.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.online.shop.domain.entities.Order;
import com.online.shop.domain.entities.OrderItem;
import com.online.shop.domain.entities.Product;
import com.online.shop.domain.enums.OrderStatus;
import com.online.shop.domain.repositories.OrderRepository;
import com.online.shop.domain.repositories.ProductRepository;
import com.online.shop.domain.services.OrderService;

/**
 *
 * @author tlobutov
 */
@Service
public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository;
    ProductRepository productRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {

        this.orderRepository = orderRepository;

    }

    @Override
    public Order createOrder(Order order) {

        order.setOrderStatus(OrderStatus.CREATED);

        List<Product> products = getOrderProducts(order.getOrderItems());
        BigDecimal totalPrice = calculateTotalPrice(products, order.getOrderItems());
        order.setTotalPrice(totalPrice);
        
        return orderRepository.saveOrder(order);

    }

    private List<Product> getOrderProducts(List<OrderItem> orderItems) {
        List<Long> ids = new ArrayList<>();

        for (OrderItem orderItem : orderItems) {

            ids.add(orderItem.getProduct().getId());

        }
        return productRepository.getProducts(ids);
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

    }

    private BigDecimal calculateTotalPrice(List<Product> products, List<OrderItem> orderItems) {

        BigDecimal totalPrice = BigDecimal.ZERO;

        for (int i = 0; i < orderItems.size(); i++) {

            Integer quantity = orderItems.get(i).getQuantity();

            Long productID = orderItems.get(i).getProduct().getId();
            // Integer productIDconv = productID.intValue();
            for (Product product : products) {

                if (product.getId() == productID) {
                    BigDecimal itemTotalPrice = product.getPrice().multiply(BigDecimal.valueOf(quantity));
                    totalPrice = totalPrice.add(itemTotalPrice);
                    break;
                }

            }

        }

        return totalPrice;
    };

}
