package com.example.orderenricher.controller;

import com.example.orderenricher.model.Order;
import com.example.orderenricher.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(OrderController.class)
class OrderControllerTest {
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Test
    void receiveOrder_shouldReturnOk() throws Exception {
        String json = """
            {
              "orderId": "O123",
              "customerId": "C1",
              "productIds": ["P1"],
              "timestamp": "2025-07-17T15:00:00Z"
            }
            """;

        mockMvc.perform(post("/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
    }

}
