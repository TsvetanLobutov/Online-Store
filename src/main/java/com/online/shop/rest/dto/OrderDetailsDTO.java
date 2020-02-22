package com.online.shop.rest.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.online.shop.domain.entities.Order;

import lombok.Data;

@Data
public class OrderDetailsDTO extends OrderDTO {

    private List<OrderItemDTO> orderItems;

    public OrderDetailsDTO(Order order) {

        super(order);

        this.orderItems = order.getOrderItems()
                .stream()
                .map(OrderItemDTO::new)
                .collect(Collectors.toList());
    }

    public Order toOrder() {

        Order order = new Order();

        BeanUtils.copyProperties(this, order);

        return order;

    }

    public Order toEntity(Long id) {

        Order order = this.toOrder();

        order.setId(id);

        return order;
    }

}
