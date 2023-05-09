package com.example.twentyFourCoding.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pizza")
public class Pizza {
	
	@Id
	private long pizzaId;
	
	private char size;
	
	private double price;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "pizza")
	private List<PizzaType> pizzaType;
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "pizza")
	private List<OrderDetails> orderDetails;
	
	public Pizza(){}

	public Pizza(long pizzaId, char size, double price) {
		super();
		this.pizzaId = pizzaId;
		this.size = size;
		this.price = price;
	}

	public long getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(long pizzaId) {
		this.pizzaId = pizzaId;
	}

	public char getSize() {
		return size;
	}

	public void setSize(char size) {
		this.size = size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<PizzaType> getPizzaType() {
		return pizzaType;
	}

	public void setPizzaType(List<PizzaType> pizzaType) {
		this.pizzaType = pizzaType;
	}

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	
	
	
	

}
