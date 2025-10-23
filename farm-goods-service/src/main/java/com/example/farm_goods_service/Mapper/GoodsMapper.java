package com.example.farm_goods_service.Mapper;

import com.example.farm_goods_service.Model.Goods;
import com.example.farm_goods_service.dto.GoodsRequestDto;
import com.example.farm_goods_service.dto.GoodsResponseDto;

import java.time.LocalDate;
import java.util.UUID;

public class GoodsMapper {
    public static GoodsResponseDto toDto(Goods goods) {
        GoodsResponseDto dto = new GoodsResponseDto();
        dto.setId(goods.getId().toString());
        dto.setProductName(goods.getProductName());
        dto.setProductType(goods.getProductType());
        dto.setQuantityAvailable(goods.getQuantityAvailable());
        dto.setUnitPrice(goods.getUnitPrice());
        dto.setHarvestDate(goods.getHarvestDate().toString());
        dto.setExpiryDate(goods.getExpiryDate().toString());
        return dto;
    }

    public static Goods toModel(GoodsRequestDto dto) {
        Goods goods = new Goods();
        goods.setProductName(dto.getProductName());
        goods.setProductType(dto.getProductType());
        goods.setQuantityAvailable(dto.getQuantityAvailable());
        goods.setUnitPrice(dto.getUnitPrice());
        goods.setHarvestDate(LocalDate.parse(dto.getHarvestDate()));
        goods.setExpiryDate(LocalDate.parse(dto.getExpiryDate()));
        return goods;
    }
}
