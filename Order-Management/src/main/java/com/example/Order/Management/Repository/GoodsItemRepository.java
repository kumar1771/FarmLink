package com.example.Order.Management.Repository;

import com.example.Order.Management.Method.GoodsItem;
import com.example.Order.Management.dto.GoodsItemDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GoodsItemRepository extends JpaRepository<GoodsItem, UUID> {
    // Find all goods for a specific order
    List<GoodsItem> findByOrderOrderId(UUID orderId);
}
