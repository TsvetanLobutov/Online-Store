package com.online.shop.rest.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.online.shop.domain.entities.Order;
import com.online.shop.domain.entities.OrderItem;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDetailsDTO extends OrderDTO {

    private List<OrderItemDTO> orderItems;

    public OrderDetailsDTO(Order order) {

        super(order);

        this.orderItems = order.getOrderItems().stream().map(OrderItemDTO::new).collect(Collectors.toList());
    }

    public Order toEntity() {

        Order order = super.toEntity();
        List<OrderItem> orderItems = new ArrayList<>();

        for (int i = 0; i < this.orderItems.size(); i++) {

            OrderItem orderItem = this.orderItems.get(i).toEntity();
            orderItem.setOrder(order);
            orderItems.add(orderItem);

        }

        order.setOrderItems(orderItems);

        return order;

    }

    public Order toEntity(Long id) {

        Order order = this.toEntity();

        order.setId(id);

        return order;
    }

}
