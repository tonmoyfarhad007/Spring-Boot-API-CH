package com.example.twentyFourCoding.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderDetails")
public class OrderDetails {
	
	@Id
	private long orderDetailsId;
	
	private String pizzaId;
	
	private int quantity;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "order_id",referencedColumnName = "orderId")
	private Order order;
	
	
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(
	    name = "orderDetails_pizza",
	    joinColumns = {@JoinColumn(name = "order_details_id")},
	    inverseJoinColumns = {@JoinColumn(name = "pizza_id")}
	)
	private List<Pizza> pizza;
	
	public OrderDetails() {
		
	}
	
	public OrderDetails(long orderDetailsId, String pizzaId, int quantity) {
		super();
		this.orderDetailsId = orderDetailsId;
		this.pizzaId = pizzaId;
		this.quantity = quantity;
//		order.setOrderId(orderId);
	}
	

	public long getOrderDetailsId() {
		return orderDetailsId;
	}

	public void setOrderDetailsId(long orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}


	public String getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(String pizzaId) {
		this.pizzaId = pizzaId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Order getOrder() {
		return order;
	}
	
	

	public List<Pizza> getPizza() {
		return pizza;
	}

	public void setPizza(List<Pizza> pizza) {
		this.pizza = pizza;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderDetailsId=" + orderDetailsId + ", pizzaId=" + pizzaId
				+ ", quantity=" + quantity + "]";
	}

	
	
	

}
