package com.example.farm_goods_service.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public class GoodsRequestDto {

    @NotBlank(message = "Product name is required")
    @Size(max = 100, message = "Product name can't exceed 100 characters")
    private String productName;

    @NotBlank(message = "Product type is required")
    @Size(max = 50, message = "Product type can't exceed 50 characters")
    private String productType;

    @NotNull(message = "Quantity available is required")
    @Positive(message = "Quantity must be positive")
    private Integer quantityAvailable;

    @NotNull(message = "Unit price is required")
    @Positive(message = "Unit price must be positive")
    private Double unitPrice;

    @NotBlank(message = "Harvest date is required")
    private String harvestDate;  // ISO date string

    @NotBlank(message = "Expiry date is required")
    private String expiryDate;   // ISO date string

    // Getters and setters

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

    public String getHarvestDate() {
        return harvestDate;
    }

    public void setHarvestDate(String harvestDate) {
        this.harvestDate = harvestDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public GoodsRequestDto(String productName, String productType, Integer quantityAvailable, Double unitPrice, String harvestDate, String expiryDate) {
        this.productName = productName;
        this.productType = productType;
        this.quantityAvailable = quantityAvailable;
        this.unitPrice = unitPrice;
        this.harvestDate = harvestDate;
        this.expiryDate = expiryDate;
    }
}
