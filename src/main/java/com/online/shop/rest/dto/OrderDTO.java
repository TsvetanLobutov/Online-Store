package com.online.shop.rest.dto;

import org.springframework.beans.BeanUtils;

import com.online.shop.domain.entities.Order;
import com.online.shop.domain.enums.OrderStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDTO {

    private Long id;

    private String customerFirstName;

    private String customerLastName;

    private OrderStatus orderStatus;

    public OrderDTO(Order order) {

        BeanUtils.copyProperties(order, this);

    }

    public Order toEntity() {

        Order order = new Order();

        BeanUtils.copyProperties(this, order);

        return order;

    }

    public Order toEntity(Long id) {

        Order order = this.toEntity();

        order.setId(id);

        return order;
    }

}
