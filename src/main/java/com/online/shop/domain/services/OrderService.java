package com.online.shop.domain.services;

import com.online.shop.domain.entities.Order;

public interface OrderService {

	public Order createOrder(Order order);
        
       public Order getOrder(Long id); 
       
       public void cancelOrder(Long id);
	
        
        
}
