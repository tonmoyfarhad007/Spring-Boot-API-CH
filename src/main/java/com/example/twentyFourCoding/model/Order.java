package com.example.twentyFourCoding.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	private long orderId;
	
	private String date;
	
	private String time;
	
	
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order")
	private OrderDetails orderDetails;

	
	
	public Order() {}
	
	public Order(long orderId, String date, String time) {
		super();
		this.orderId = orderId;
		this.date = date;
		this.time = time;
	}

	public Order(long orderId, String date, String time, OrderDetails orderDetails) {
		super();
		this.orderId = orderId;
		this.date = date;
		this.time = time;
		this.orderDetails = orderDetails;
	}




	public long getOrderId() {
		return orderId;
	}


	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public OrderDetails getOrderDetails() {
		return orderDetails;
	}


	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	
	
	
	
	

}
