package com.example.orderenricher.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	
	private String orderId;
    private String customerId;
    private List<String> productIds;
    private String timestamp;

}
