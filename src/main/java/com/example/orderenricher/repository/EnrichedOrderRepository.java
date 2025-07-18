package com.example.orderenricher.repository;

import com.example.orderenricher.model.EnrichedOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrichedOrderRepository extends JpaRepository<EnrichedOrder, String> {
	List<EnrichedOrder> findByCustomerId(String customerId);
	//List<EnrichedOrder> findByProducts_ProductId(String productId);
}


