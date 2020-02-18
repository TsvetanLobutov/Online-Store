package com.online.shop.domain.repositories;

import com.online.shop.domain.entities.Order;

public interface OrderRepository {
	
	Order saveNewOrder(Order order);
	
        Order getOrder(Long id);

}
