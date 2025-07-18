package com.example.orderenricher.controller;

import com.example.orderenricher.model.EnrichedOrder;
import com.example.orderenricher.model.Order;
import com.example.orderenricher.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")

public class OrderController {
	
	@Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<String> receiveOrder(@RequestBody Order order) {
        orderService.processAndSaveOrder(order);
        return ResponseEntity.ok("Order enriched and saved.");
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<EnrichedOrder> getOrder(@PathVariable String orderId) {
        return ResponseEntity.ok(orderService.getOrder(orderId));
    }

    @GetMapping
    public ResponseEntity<List<EnrichedOrder>> filterOrders(@RequestParam(required = false) String customerId,
                                                            @RequestParam(required = false) String productId) {
        return ResponseEntity.ok(orderService.filterOrders(customerId, productId));
    }

}
