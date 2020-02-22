/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.shop.domain.enums;

/**
 *
 * @author tlobutov
 */
public enum OrderSatatus implements CodeEnum{

    CREATED(0, "New Order"),
    PAYED(1, "Payed"),
    FULFILLED(2, "Fulfilled"),
    CANCELED(3, "Canceled");;
    
    private int code;
    private String message;

    OrderSatatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    
    

    @Override
    public Integer getCode() {
        return code;
    }

    
}
