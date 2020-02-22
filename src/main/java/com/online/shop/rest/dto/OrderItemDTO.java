/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.shop.rest.dto;

import com.online.shop.domain.entities.Order;
import com.online.shop.domain.entities.OrderItem;
import lombok.NoArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;

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
    
    
    public OrderItemDTO(OrderItem orderItem){
        
        BeanUtils.copyProperties(orderItem, this);
        this.product = new ProductDTO(orderItem.getProduct());
        
    }
    
    public OrderItem toOrderItem(){
        
        OrderItem orderItem = new OrderItem();
        
        BeanUtils.copyProperties(this, orderItem);
        
        return orderItem;
        
    }
    
    public OrderItem toEntity(Long id){
        
        OrderItem orderItem = new OrderItem();
        
        orderItem.setId(id);
        
        return orderItem;
    }
    

}
