package com.techstack.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Assert.*;
import org.mockito.junit.MockitoJUnitRunner;

import com.techstack.model.Product;
import com.techstack.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {
	
	@Mock
	private ProductRepository productRepository;
	@InjectMocks
	private ProductServiceImpl testClass; // Class to be tested
	
	@Before
	public void setup() {
		Product prod = Initializer.getProduct();
		List<Product> prods = Initializer.getProductList();
		when(productRepository.getProductById("testid")).thenReturn(prod);
		when(productRepository.getAllProducts()).thenReturn(prods);
	}
	@Ignore
	@Test
	public void testGetProductById() {
		
		Product product = testClass.getProductById("testid");
		assertEquals("productid1",product.getProductId());
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testCalculateTotal() {
		
		double actualTotal = testClass.calculateTotal(Initializer.getProductList());
		assertEquals(2000.0,actualTotal,1);
		
	}

}
