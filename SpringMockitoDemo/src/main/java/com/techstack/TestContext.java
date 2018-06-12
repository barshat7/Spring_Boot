package com.techstack;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.techstack.service.OrderService;

@Configuration
public class TestContext {
	
	@Bean
	public OrderService orderService() {
		
		return Mockito.mock(OrderService.class);
	}
	
}
