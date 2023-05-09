package com.example.twentyFourCoding.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pizzaType")
public class PizzaType {
	
	
	@Id
	private long pizzaTypeId;
	
	private String name;
	
	private String category;
	
	private String ingredient;
	
	@ManyToOne
	@JoinColumn(name = "pizza_id",referencedColumnName = "pizzaId", nullable = false)
	private Pizza pizza;

	public PizzaType() {}
	
	public PizzaType(long pizzaTypeId, String name, String category, String ingredient, Pizza pizza) {
		super();
		this.pizzaTypeId = pizzaTypeId;
		this.name = name;
		this.category = category;
		this.ingredient = ingredient;
		this.pizza = pizza;
	}

	public long getPizzaTypeId() {
		return pizzaTypeId;
	}

	public void setPizzaTypeId(long pizzaTypeId) {
		this.pizzaTypeId = pizzaTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	
	
	

}
