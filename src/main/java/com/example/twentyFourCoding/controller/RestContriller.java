package com.example.twentyFourCoding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.twentyFourCoding.handleCSV.CSVhandler;
import com.example.twentyFourCoding.model.Order;
import com.example.twentyFourCoding.model.OrderDetails;
import com.example.twentyFourCoding.service.OrderDetailsService;
import com.example.twentyFourCoding.service.OrderService;

@RestController
public class RestContriller {
	
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderDetailsService orderDetailsService;
	
	@Autowired
	CSVhandler csvHandler;
	
	
	@GetMapping("/welcome")
	public String welCome() {
		return "welcome to 24 codding challenge";
	}
	
	@GetMapping("/getAllOrders")
	public List<Order> getAllOrder(){
		return orderService.getAllOrders();
	}
	
	@PostMapping("/uploadCSV")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message;
	    System.out.println(file.getOriginalFilename());
		try {
			if(file.getOriginalFilename().equalsIgnoreCase("orders.csv")) {
				orderService.saveAllOrders(csvHandler.csvToOrders(file.getInputStream()));
				return ResponseEntity.ok(file.getOriginalFilename()+" uploded to database successfully");
			}
//			else if(file.getOriginalFilename().equalsIgnoreCase("order_details.csv")) {
//				orderDetailsService.saveAllOrdersDetails(csvHandler.csvToOrderDetails(file.getInputStream()));
//				return ResponseEntity.ok(file.getOriginalFilename()+" uploded to database successfully");
//			}
			else {
				return ResponseEntity.ok("please upload correct file");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	        return ResponseEntity.ok(message);
	      
			
		}
	    
	}

}
