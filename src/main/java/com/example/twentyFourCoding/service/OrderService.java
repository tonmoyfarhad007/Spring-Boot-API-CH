package com.example.twentyFourCoding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.twentyFourCoding.model.Order;
import com.example.twentyFourCoding.model.OrderDetails;
import com.example.twentyFourCoding.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	
	public List<Order> getAllOrders(){
		return orderRepository.findAll();
	}	
	
	public void saveSingleOrder(long orderId, String date, String time){
		Order order = new Order(orderId, date, time);
		orderRepository.save(order);
	}
	
	public void saveAllOrders(List<Order> orders) {
		orderRepository.saveAll(orders);
	}
	
	public void saveOrderWithDetails(long orderId, String date, String time, OrderDetails orderDetails){
		Order order = new Order(orderId, date, time);
		order.setOrderDetails(orderDetails);
		orderRepository.save(order);
	}

}
