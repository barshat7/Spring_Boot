package com.techstack.model;


public class Product {
	
	private String productId;
	private String productName;
	private Double price;
	public Product() {
		
	}
	public Product(String productId, String productName, Double price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
