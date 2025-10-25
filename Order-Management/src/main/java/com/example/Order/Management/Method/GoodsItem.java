package com.example.Order.Management.Method;

import com.example.Order.Management.dto.OrderRequestDto;
import jakarta.persistence.*;

import java.util.UUID;
@Entity
@Table(name = "goods_item")
public class GoodsItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID goodsId;
    private int quantity;
    private double price;

    public OrderRequest getOrder() {
        return order;
    }

    public void setOrder(OrderRequest order) {
        this.order = order;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private OrderRequest order;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
