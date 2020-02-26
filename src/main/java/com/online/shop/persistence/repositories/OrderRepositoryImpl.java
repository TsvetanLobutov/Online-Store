package com.online.shop.persistence.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.shop.domain.entities.Order;
import com.online.shop.domain.entities.Product;
import com.online.shop.domain.exceptions.ResourceNotFoundExeption;
import com.online.shop.domain.repositories.OrderRepository;
import com.online.shop.domain.repositories.springdata.OrderRepositorySD;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

	private final OrderRepositorySD orderRepositorySD;
	
	@Autowired
	public OrderRepositoryImpl(OrderRepositorySD orderRepositorySD) {
		
		this.orderRepositorySD = orderRepositorySD;
		
	}
	
	@Override
	public Order saveOrder(Order order) {
		
		return orderRepositorySD.save(order); 
	}

    @Override
    public Order getOrder(Long id) {
      
               Order order = orderRepositorySD.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Order with ID: " + id + " does not exist"));
               order.getOrderItems();
               
               return order;
    }
    
    @Override
    public List<Order> searchOrders() {
        
        return orderRepositorySD.findAll();
        
    }

}
