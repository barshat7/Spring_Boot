package com.techstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techstack.model.Order;
import com.techstack.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	@GetMapping("/{id}")
	public Order getOrder(@PathVariable("id")Long id) {
		
		System.out.println("Order Controller: getOrder() by " +id);
		return orderService.getOrderById(id);
	}
	@GetMapping("/test")
	public String testing() {
		
		System.out.println("TEST WOrking");
		return "test";
	}
}
