package com.example.domain;

public class Order {

	private long orderId;
	private int customerId;
	private double price;
	private String orderCode;

	public Order(long orderId, int customerId, double price, String orderCode) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.price = price;
		this.orderCode = orderCode;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	@Override
	public String toString() {
		return "{orderId:"+orderId +",customerId:"+ customerId+",price:"+price+",orderCode:"+orderCode+"}"; 
	}
}