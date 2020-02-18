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
public enum OrderSatatusEnum implements CodeEnum{

    NEW(0, "New Order"),
    FINISHED(1, "Finished"),
    CANCELED(2, "Canceled");
    
    private int code;
    private String message;

    OrderSatatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    
    

    @Override
    public Integer getCode() {
        return code;
    }

    
}
