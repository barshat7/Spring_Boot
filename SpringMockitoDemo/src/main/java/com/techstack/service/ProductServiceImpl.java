package com.techstack.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techstack.model.Product;
import com.techstack.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
	@Override
	public List<Product> getAllProducts() {
		
		return productRepository.getAllProducts();
	}

	@Override
	public Product getProductById(String id) {
		
		return productRepository.getProductById(id);
	}

	@Override
	public Double calculateTotal(List<Product> products) {
		
		double total = 0.0;
		for(Product product:products) {
			total +=product.getPrice();
		}
		return total;
	}

	@Override
	public void saveProduct(Product product) {
		
		String id = (String) productRepository.saveProduct(product);
	}

}
