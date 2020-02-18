package com.online.shop.rest.dto;

import java.util.List;

import org.springframework.beans.BeanUtils;
import com.online.shop.domain.entities.Order;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDTO {

    private Long id;

    private List<OrderItemDTO> products;

    private String customerFirstName;

    private String customerLastName;

    private Integer orderStatus;

    public OrderDTO(Order order) {

        BeanUtils.copyProperties(order, this);

    }

    public Order toOrder() {

        Order order = new Order();

        BeanUtils.copyProperties(this, order);

        return order;

    }

    public Order toEntity(Long it) {

        Order order = this.toOrder();

        order.setId(id);

        return order;
    }

}
