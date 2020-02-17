package com.online.shop.domain.exceptions;

public class ResourceNotFoundExeption extends RuntimeException {
	
	private final String message;
	
	public ResourceNotFoundExeption(String message) {
		this.message = message;
	}
	
}
