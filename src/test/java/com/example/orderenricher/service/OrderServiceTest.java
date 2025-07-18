package com.example.orderenricher.service;

import com.example.orderenricher.model.Customer;
import com.example.orderenricher.model.Order;
import com.example.orderenricher.model.Product;
import com.example.orderenricher.repository.EnrichedOrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mockito.*;

import java.util.List;


import static org.mockito.Mockito.*;

class OrderServiceTest {
	
	@InjectMocks
    private OrderService orderService;

    @Mock
    private CustomerService customerService;

    @Mock
    private ProductService productService;

    @Mock
    private EnrichedOrderRepository repository;

    @Spy 
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void processAndSaveOrder_shouldCallSave() {
        // Arrange
        Order order = new Order("O123", "C1", List.of("P1"), "2025-07-17T15:00:00Z");

        Customer customer = new Customer("C1", "John Doe", "123 Main St", "12345", "USA");
        Product product = new Product("P1", "Widget", 15.0, "Tools", "tech,sale");

        when(customerService.getCustomer("C1")).thenReturn(customer);
        when(productService.getProduct("P1")).thenReturn(product);

        // Act
        orderService.processAndSaveOrder(order);

        // Assert
        verify(repository, times(1)).save(any());
    }
    }
