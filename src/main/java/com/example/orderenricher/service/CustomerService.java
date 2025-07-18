package com.example.orderenricher.service;

import com.example.orderenricher.model.Customer;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CustomerService {
	
	 private static final Map<String, Customer> CUSTOMER_DATA = Map.of(
		        "C1", new Customer("C1", "John Doe", "123 Main St", "12345", "USA"),
		        "C2", new Customer("C2", "Jane Smith", "456 Oak St", "67890", "USA")
		    );

		    public Customer getCustomer(String id) {
		        return CUSTOMER_DATA.get(id);  // will return null if id doesn't match
		    }

}
