package com.online.shop.domain.entities;

import com.online.shop.domain.enums.OrderSatatus;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Data
@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private List<Product> products;
	
	private String customerFirstName;
	
	private String customerLastName;
	
	private BigDecimal totalPrice;
        
        private OrderSatatus orderSatus;
        
        @NotNull
        @ColumnDefault("0")
        private Integer orderStatus;
	

}
