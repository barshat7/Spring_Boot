package com.techstack.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.techstack.SpringMockitoDemoApplication;
import com.techstack.TestContext;
import com.techstack.model.Order;
import com.techstack.service.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
// if we prefer XML configuration, 
//we have to set the configuration files as the value of the locations attribute.
@WebAppConfiguration
@ContextConfiguration(classes= {TestContext.class,SpringMockitoDemoApplication.class})
public class OrderControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private OrderService orderServiceMock;
	
	@Autowired
	private WebApplicationContext context;
	
	@Before
	public void setup() {
		
		Order order = new Order();
		order.setDescription("test");
		Mockito.reset(orderServiceMock);
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		when(orderServiceMock.getOrderById(100L)).thenReturn(order);
		
	}
	
	
	
	@Test
	public void testGetOrder() throws Exception {
		
		mockMvc.perform(get("/order/100"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.description",is("test")));
		
		/*mockMvc.perform(get("/order/test"))
		.andExpect(status().isOk());*/
	}

}
