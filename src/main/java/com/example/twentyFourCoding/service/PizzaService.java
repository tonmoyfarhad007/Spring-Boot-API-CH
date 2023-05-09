package com.example.twentyFourCoding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.twentyFourCoding.model.Order;
import com.example.twentyFourCoding.model.OrderDetails;
import com.example.twentyFourCoding.model.Pizza;
import com.example.twentyFourCoding.model.PizzaType;
import com.example.twentyFourCoding.repository.PizzaRepository;

@Service
public class PizzaService {
	
	@Autowired
	PizzaRepository pizzaRepository;
	
	
	public List<Pizza> getAllPizza(){
		return pizzaRepository.findAll();
	}
	
	public void saveSinglePizza(long pizzaId, char size, double price){
		Pizza pizza = new Pizza(pizzaId, size, price);
		pizzaRepository.save(pizza);
	}
	
	public void saveAllPizzas(List<Pizza> pizzas) {
		pizzaRepository.saveAll(pizzas);
	}
	
	public void savePizzaWithType(long pizzaId, char size, double price, List<PizzaType> pizzaType){
		Pizza pizza = new Pizza(pizzaId, size, price);
		pizza.setPizzaType(pizzaType);
		pizzaRepository.save(pizza);
	}

}
