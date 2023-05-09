package com.example.twentyFourCoding.handleCSV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.example.twentyFourCoding.model.Order;
import com.example.twentyFourCoding.model.OrderDetails;

@Service
public class CSVhandler {

	public List<Order> csvToOrders(InputStream is) {

		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

			
			List<Order> orders = new ArrayList<Order>();

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();

			for (CSVRecord csvRecord : csvRecords) {
				Order order = new Order(Long.parseLong(csvRecord.get("order_id")), csvRecord.get("date"), csvRecord.get("time"));
				orders.add(order);
			}
			
			
			return orders;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}
	
	public List<OrderDetails> csvToOrderDetails(InputStream is) {

		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

			List<OrderDetails> orderDetails = new ArrayList<OrderDetails>();

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();

			for (CSVRecord csvRecord : csvRecords) {
				
				OrderDetails orderDetail = new OrderDetails(
							Long.parseLong(csvRecord.get("order_details_id")),
							csvRecord.get("pizza_id"),
							Integer.parseInt(csvRecord.get("quantity"))
						);
				orderDetails.add(orderDetail);
			}
			
			
			return orderDetails;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}

}
