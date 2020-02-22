package com.online.shop.domain.repositories.springdata;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.online.shop.domain.entities.Order;
import com.online.shop.domain.entities.Product;

public interface OrderRepositorySD extends CrudRepository<Order, Long>{

    List<Order> findAll();
    
}
