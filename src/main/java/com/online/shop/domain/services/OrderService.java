package com.online.shop.domain.services;

import java.util.List;

import com.online.shop.domain.entities.Order;
import com.online.shop.domain.entities.Product;

public interface OrderService {

	public Order createOrder(Order order);
        
       public Order getOrder(Long id); 
       
       public void cancelOrder(Long id);
	
       public List<Order> searchOrders(); 
        
}
