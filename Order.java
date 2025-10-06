package com.ecommerce.orders;

import java.util.List;
import com.ecommerce.Product;
import com.ecommerce.Customer;

public class Order {
	private int orderID;
	private Customer customer;
	private List<Product> products;
	private String status;
	private double orderTotal;
	public Order(int orderID, Customer customer, List<Product> products) {
		this.orderID = orderID;
		this.customer = customer;
		this.products = products;
		this.orderTotal = calculatingTotal();
		this.status = "Places";
	}
	private double calculatingTotal() {
		double total = 0;
		for (Product product : products) {
			total = total + product.getPrice();
		}
		return total;
	}
	public void updating_Stuatus(String status) {
		this.status = status;
	}
	public void viewing_Order() {
		System.out.println("Order ID: " + orderID);
		System.out.println("Customer: " + customer.getName());
		System.out.println("Products: ");
		for (Product product : products) {
			System.out.println(" - "+ product.getName() + " : " + product.getPrice());
		}
		System.out.println("Total Order: " + orderTotal);
		System.out.println("Status of order " + status);
	}
}
