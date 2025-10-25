package com.example.Order.Management.Repository;

import com.example.Order.Management.Method.OrderRequest;
import com.example.Order.Management.dto.OrderRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRequestRepository extends JpaRepository<OrderRequest, UUID> {
    // Optional: custom queries if needed later
}