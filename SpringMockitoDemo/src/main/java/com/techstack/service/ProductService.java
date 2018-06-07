package com.techstack.service;

import java.util.List;

import com.techstack.model.Product;

public interface ProductService {

	public List<Product> getAllProducts();
	public Product getProductById(String id);
	public Double calculateTotal(List<Product> products);
	public String saveProduct(Product product);
}
