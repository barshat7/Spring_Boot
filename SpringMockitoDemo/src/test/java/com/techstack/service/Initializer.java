package com.techstack.service;

import java.util.ArrayList;
import java.util.List;

import com.techstack.model.Product;

public class Initializer {

	public static Product getProduct() {
		Product prod = new Product("productid1","productname1",1000.0);
		return prod;
	}
	public static List<Product> getProductList(){
		
		List<Product> products = new ArrayList<>();
		products.add(getProduct());
		products.add(getProduct());
		products.add(getProduct());
		return products;
	}
}
