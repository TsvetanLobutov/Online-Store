package com.online.shop.persistence.repositories;

import org.springframework.beans.factory.annotation.Autowired;

import com.online.shop.domain.entities.Order;
import com.online.shop.domain.exceptions.ResourceNotFoundExeption;
import com.online.shop.domain.repositories.OrderRepository;
import com.online.shop.domain.repositories.springdata.OrderRepositorySD;


public class OrderRepositoryImpl implements OrderRepository {

	private final OrderRepositorySD orderRepositorySD;
	
	@Autowired
	public OrderRepositoryImpl(OrderRepositorySD orderRepositorySD) {
		
		this.orderRepositorySD = orderRepositorySD;
		
	}
	
	@Override
	public Order createOrder(Order order) {
		
		return orderRepositorySD.save(order); 
	}

    @Override
    public Order getOrder(Long id) {
        return orderRepositorySD.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Order with ID: " + id + " does not exist"));
    }

}
