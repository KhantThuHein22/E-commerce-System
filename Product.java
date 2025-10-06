package com.ecommerce;

public class Product {
	private int productID;
	private String name;
	private double price;
	
	public Product (int productID, String name, double price) {
		this.productID = productID;
		this.name = name;
		this.price = price;
	}
	
	// Using Getters
	public int getProductID() {
		return productID;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	// Setting Setters
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void showing_Product() {
		System.out.println("ID of Product: " + productID + "- Name: " + name +"- Price: " + price );
		
	}
	
}
