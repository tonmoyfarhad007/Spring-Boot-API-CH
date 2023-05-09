package com.example.twentyFourCoding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.twentyFourCoding.model.OrderDetails;
import com.example.twentyFourCoding.model.PizzaType;
import com.example.twentyFourCoding.repository.PizzaTypeRepository;

@Service
public class PizzaTypeService {
	
	@Autowired
	PizzaTypeRepository pizzaTypeService;
	
	public List<PizzaType> getAllPizzaType() {
		return pizzaTypeService.findAll();
	}

}
