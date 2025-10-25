package com.example.Order.Management.dto;

import jakarta.persistence.*;

import java.util.UUID;

public class GoodsItemDto {
    private UUID goodsId;
    private int quantity;
    private double price;

    public UUID getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(UUID goodsId) {
        this.goodsId = goodsId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
