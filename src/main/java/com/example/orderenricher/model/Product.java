package com.example.orderenricher.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	private String productId;
    private String name;
    private double price;
    private String category;
    private String tags;

}
