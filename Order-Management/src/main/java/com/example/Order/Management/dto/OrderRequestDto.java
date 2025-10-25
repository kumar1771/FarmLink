package com.example.Order.Management.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderRequestDto {

    private UUID customerId;
    @JsonProperty("item")
    private List<GoodsItemDto> goods;

    public List<GoodsItemDto> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsItemDto> goods) {
        this.goods = goods;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

}
