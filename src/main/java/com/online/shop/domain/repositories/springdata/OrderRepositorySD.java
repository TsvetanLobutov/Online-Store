package com.online.shop.domain.repositories.springdata;

import org.springframework.data.repository.CrudRepository;

import com.online.shop.domain.entities.Order;

public interface OrderRepositorySD extends CrudRepository<Order, Long>{

}
