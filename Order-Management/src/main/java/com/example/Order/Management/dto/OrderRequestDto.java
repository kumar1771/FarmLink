package com.example.Order.Management.dto;

import java.util.List;
import java.util.UUID;

public class OrderRequestDto {
    private UUID customerId;
    private List<GoodsItemDto> item;

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public List<GoodsItemDto> getItem() {
        return item;
    }

    public void setItem(List<GoodsItemDto> item) {
        this.item = item;
    }
}
