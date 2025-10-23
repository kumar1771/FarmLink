package com.example.farm_goods_service.Cotroller;

import com.example.farm_goods_service.Model.Account;
import com.example.farm_goods_service.Service.GoodsService;
import com.example.farm_goods_service.dto.GoodsRequestDto;
import com.example.farm_goods_service.dto.GoodsResponseDto;
import com.example.farm_goods_service.grpc.GoodsServiceGrpcClient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/goods")
@Tag(name = "goods", description = "API for managing goods")
public class GoodsController {

    private final GoodsService goodsService;
    private GoodsServiceGrpcClient goodsServiceGrpcClient;

    public GoodsController(GoodsService goodsService,GoodsServiceGrpcClient goodsServiceGrpcClient) {
        this.goodsService = goodsService;
        this.goodsServiceGrpcClient = goodsServiceGrpcClient;
    }

    @GetMapping("/Account")
    @Operation(summary = "Get Account Details")
    public Account getAccountDetails(){
        return goodsService.getAccount();
    }
    @GetMapping
    @Operation(summary = "Get all goods details")
    public ResponseEntity<List<GoodsResponseDto>> getGoods() {
        List<GoodsResponseDto> goods = goodsService.getGoods();

        return ResponseEntity.ok().body(goods);
    }

    @PostMapping
    @Operation(summary = "Create new goods entry")
    public ResponseEntity<GoodsResponseDto> createGoods(@Valid @RequestBody GoodsRequestDto goodsRequestDto) {
        GoodsResponseDto responseDto = goodsService.createGoods(goodsRequestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update goods details")
    public ResponseEntity<GoodsResponseDto> updateGoods(
            @PathVariable UUID id,
            @Validated({Default.class}) @RequestBody GoodsRequestDto goodsRequestDto) {
        GoodsResponseDto responseDto = goodsService.updateGoods(id, goodsRequestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete goods by ID")
    public ResponseEntity<Void> deleteGoods(@PathVariable UUID id) {
        goodsService.deleteGoods(id);
        return ResponseEntity.noContent().build();
    }
}
