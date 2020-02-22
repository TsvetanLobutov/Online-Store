package com.online.shop.domain.repositories;

import java.util.List;

import com.online.shop.domain.entities.Order;
import com.online.shop.domain.entities.Product;

public interface OrderRepository {
	
	Order createOrder(Order order);
	
        Order getOrder(Long id);
        
        List<Order> searchOrders();
        


}
