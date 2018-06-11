package com.techstack.controller;



import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techstack.model.Product;
import com.techstack.service.Initializer;
import com.techstack.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductControllerTest {

	@Mock
	private ProductService productService;
	
	@InjectMocks
	private ProductController productController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		
		mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
		Product testProd = Initializer.getProduct();
		List<Product> testProdList = Initializer.getProductList();
		when(productService.getProductById("test")).thenReturn(testProd);
		when(productService.getAllProducts()).thenReturn(testProdList);
		when(productService.saveProduct(Mockito.any())).thenReturn("resource created");
		
	}
	
	@Ignore
	@Test
	public void testGetProductById() throws Exception {
		
		mockMvc.perform(get("/product/test"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.productName",is("productname1")));
			
	}
	
	@Ignore
	@Test
	public void testGetAllProducts() throws Exception {
		
		mockMvc.perform(get("/product/all"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", hasSize(3)))
			.andExpect(jsonPath("$[0].productName", is("productname1")));
	}
	
	@Test
	public void testSaveProduct() throws Exception {
		
		Product product = Initializer.getProduct();
		ObjectMapper mapper = new ObjectMapper();
		String jsonProd = mapper.writeValueAsString(product); 
		mockMvc.perform(post("/product/save")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonProd)
				).andExpect(status().isCreated());
		
		
	}
	
}
