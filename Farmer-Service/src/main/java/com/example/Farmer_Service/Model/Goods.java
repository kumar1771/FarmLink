package com.example.Farmer_Service.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    private String productName;

    @NotNull
    private String productType;

    @NotNull
    private Integer quantityAvailable;

    @NotNull
    private Double unitPrice;

    @NotNull
    private LocalDate harvestDate;

    @NotNull
    private LocalDate expiryDate;

    // Getters and setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Integer getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(Integer quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public LocalDate getHarvestDate() {
        return harvestDate;
    }

    public void setHarvestDate(LocalDate harvestDate) {
        this.harvestDate = harvestDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Goods(UUID id, String productName, String productType, Integer quantityAvailable, Double unitPrice, LocalDate harvestDate, LocalDate expiryDate) {
        this.id = id;
        this.productName = productName;
        this.productType = productType;
        this.quantityAvailable = quantityAvailable;
        this.unitPrice = unitPrice;
        this.harvestDate = harvestDate;
        this.expiryDate = expiryDate;
    }
    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productType='" + productType + '\'' +
                ", quantityAvailable=" + quantityAvailable +
                ", unitPrice=" + unitPrice +
                ", harvestDate=" + harvestDate +
                ", expiryDate=" + expiryDate +
                '}';
    }

}
