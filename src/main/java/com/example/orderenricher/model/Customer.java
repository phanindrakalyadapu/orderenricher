package com.example.orderenricher.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	private String customerId;
    private String name;
    private String street;
    private String zip;
    private String country;

}
