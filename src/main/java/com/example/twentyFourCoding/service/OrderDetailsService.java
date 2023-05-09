package com.example.twentyFourCoding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.twentyFourCoding.model.Order;
import com.example.twentyFourCoding.model.OrderDetails;
import com.example.twentyFourCoding.repository.OrderDetailsRepository;

@Service
public class OrderDetailsService {
	
	@Autowired
	OrderDetailsRepository orderDetailsRepository;
	
	
	public List<OrderDetails> getAllOrderDetails() {
		return orderDetailsRepository.findAll();
	}
	
	public void saveOrderDetails(long orderDetailsId, String pizzaId, int quantity) {
		OrderDetails orderDetails = new OrderDetails(orderDetailsId, pizzaId, quantity);
		orderDetailsRepository.save(orderDetails);
	}
	
	public void saveAllOrdersDetails(List<OrderDetails> orders) {
		orderDetailsRepository.saveAll(orders);
	}

}
