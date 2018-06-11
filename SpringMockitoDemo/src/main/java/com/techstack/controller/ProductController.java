package com.techstack.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techstack.model.Product;
import com.techstack.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/{productId}")
	public Product getProductById(@PathVariable("productId")String productId) {
		
		Product product = productService.getProductById(productId);
		return product;
	}
	@GetMapping("/all")
	public List<Product> getAllProducts(){
		
		return productService.getAllProducts();
	}
	@PostMapping("/save")
	public ResponseEntity<String> saveProduct(@RequestBody Product product){
		
		System.out.println("Controller called with: " +product.getProductName());
		String id = productService.saveProduct(product);
		return new ResponseEntity<String>(id,HttpStatus.CREATED);
	}
	
}
