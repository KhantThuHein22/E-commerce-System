package com.ecommerce;

import com.ecommerce.orders.Order;
import java.util.List;
import java.util.ArrayList;


public class Customer {
	private int customerID;
	private String name;
	private List<Product> shoppingCart;
	
	public Customer(int customerID, String name) {
		this.customerID = customerID;
		this.name = name;
		this.shoppingCart = new ArrayList<>();
	}
	
	public void adding_Product (Product product) {
		shoppingCart.add(product);
		System.out.println(product.getName() + " adding to cart.");
	}
	
	public void removing_Product (Product product) {
		shoppingCart.remove(product);
		System.out.println(product.getName() + " removing from cart.");
	}
	
	public Order order_placing(int orderID) {
		if (shoppingCart.isEmpty()) {
			System.out.println("Cannot process order. Cart is empty");
			return null;
		}
		
		Order order = new Order(orderID, this, new ArrayList<>(shoppingCart));
		shoppingCart.clear();
		System.out.println("Order successfully places. Processing");
		return order;
	}
	
	public double calculating_Total() {
		double total = 0;
		for (Product product : shoppingCart) {
			total = total + product.getPrice();
		}
		return total;
	}
	
	public void displaying_Customer() {
		System.out.println("Customer ID: " + customerID + "- Name; " + name);
		System.out.println("Shopping Cart: ");
		for (Product product : shoppingCart) {
			System.out.println(" - " + product.getName() + " : " + product.getPrice());
			
		}
	}
	
	//Setting Getter
	public String getName() {
		return name;
	}
}
