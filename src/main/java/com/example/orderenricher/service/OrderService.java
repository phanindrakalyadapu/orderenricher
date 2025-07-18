package com.example.orderenricher.service;

import com.example.orderenricher.model.*;
import com.example.orderenricher.repository.EnrichedOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final CustomerService customerService;
    private final ProductService productService;
    private final EnrichedOrderRepository repository;
    private final ObjectMapper objectMapper;

    public void processAndSaveOrder(Order order) {
        var customer = customerService.getCustomer(order.getCustomerId());
        var products = order.getProductIds().stream()
                .map(productService::getProduct)
                .collect(Collectors.toList());

        try {
            String productsJson = objectMapper.writeValueAsString(products);
            EnrichedOrder enriched = new EnrichedOrder(
                    order.getOrderId(),
                    order.getTimestamp(),
                    customer.getCustomerId(),
                    customer.getName(),
                    customer.getStreet(),
                    customer.getZip(),
                    customer.getCountry(),
                    productsJson
            );
            repository.save(enriched);
        } catch (Exception e) {
            throw new RuntimeException("Failed to serialize product list", e);
        }
    }

    public EnrichedOrder getOrder(String orderId) {
        return repository.findById(orderId).orElseThrow();
    }

    public List<EnrichedOrder> filterOrders(String customerId, String productId) {
        List<EnrichedOrder> orders;

        if (customerId != null) {
            orders = repository.findByCustomerId(customerId);
        } else {
            orders = repository.findAll();
        }

        if (productId != null) {
            return orders.stream()
                    .filter(order -> {
                        try {
                            List<Product> products = objectMapper.readValue(order.getProductsJson(),
                                    new TypeReference<List<Product>>() {});
                            return products.stream().anyMatch(p -> p.getProductId().equals(productId));
                        } catch (Exception e) {
                            return false;
                        }
                    })
                    .collect(Collectors.toList());
        }

        return orders;
    }

}
