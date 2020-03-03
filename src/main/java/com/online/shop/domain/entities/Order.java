package com.online.shop.domain.entities;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.online.shop.domain.enums.OrderStatus;

import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderItem> orderItems;

    @Column(name = "CUSTOMER_FIRST_NAME")
    private String customerFirstName;

    @Column(name = "CUSTOMER_LAST_NAME")
    private String customerLastName;

    @Column(name = "TOTAL_PRICE")
    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "ORDER_STATUS")
    private OrderStatus orderStatus;

}
