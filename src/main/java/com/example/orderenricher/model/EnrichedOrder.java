package com.example.orderenricher.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrichedOrder {
	
	@Id
    private String orderId;

    private String timestamp;

    private String customerId;
    private String customerName;
    private String customerStreet;
    private String customerZip;
    private String customerCountry;

    @Column(length = 5000)
    private String productsJson; 

}
