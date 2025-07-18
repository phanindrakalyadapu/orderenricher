package com.example.orderenricher.service;

import com.example.orderenricher.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductService {
	
	 private static final Map<String, Product> PRODUCT_DATA = Map.of(
		        "P1", new Product("P1", "Widget", 15.0, "Tools", "tech,sale"),
		        "P2", new Product("P2", "Gadget", 22.5, "Tech", "smart,battery")
		    );

		    public Product getProduct(String id) {
		        return PRODUCT_DATA.get(id);
		    }
}
