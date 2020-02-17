package com.online.shop.rest.dto;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.data.relational.core.sql.UpdateBuilder.BuildUpdate;

import com.online.shop.domain.entities.Order;
import com.online.shop.domain.entities.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDTO {
	
	private Long id;
	
	private List<Product> products;
	
	private String customerFirstName;
	
	private String customerLastName;
	
	private double totalPrice;
	
	public OrderDTO(Order order) {
		
		BeanUtils.copyProperties(order, this);
		
		this.totalPrice = order.getTotalPrice().doubleValue();
		
	}
	
	public Order toOrder() {
		
		Order order = new Order();
		
		BeanUtils.copyProperties(this, order);
                
                order.setTotalPrice(BigDecimal.valueOf(this.totalPrice));

		return order;
		
	}
        
        public Order toEntity(Long it){
            
            Order order = this.toOrder();
            
            order.setId(id);
            
            return order;
        }

}
