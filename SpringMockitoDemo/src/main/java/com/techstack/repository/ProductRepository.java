package com.techstack.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.techstack.model.Product;

@Repository
public interface ProductRepository {

	public List<Product> getAllProducts();
	public Product getProductById(String id);
	public Serializable saveProduct(Product product);
}
