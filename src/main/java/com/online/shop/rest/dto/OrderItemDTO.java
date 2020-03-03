/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.shop.rest.dto;

import org.springframework.beans.BeanUtils;

import com.online.shop.domain.entities.OrderItem;
import com.online.shop.domain.entities.Product;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author tlobutov
 */
@Data
@NoArgsConstructor
public class OrderItemDTO {

    private Long id;

    private ProductDTO product;

    private Integer quantity;

    public OrderItemDTO(OrderItem orderItem) {

        BeanUtils.copyProperties(orderItem, this);
        this.product = new ProductDTO(orderItem.getProduct());

    }

    public OrderItem toEntity() {

        Product product = this.product.toEntity();

        OrderItem orderItem = new OrderItem();

        BeanUtils.copyProperties(this, orderItem);

        orderItem.setProduct(product);

        return orderItem;

    }

    public OrderItem toEntity(Long id) {

        OrderItem orderItem = new OrderItem();

        orderItem.setId(id);

        return orderItem;
    }

}
