package com.techstack.service;

import org.springframework.stereotype.Service;

import com.techstack.model.Order;


public interface OrderService {

	public Order getOrderById(Long id);
		
	
}
