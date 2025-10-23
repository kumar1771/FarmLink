package com.example.farm_goods_service.Service;

import com.example.farm_goods_service.Mapper.GoodsMapper;
import com.example.farm_goods_service.Model.Account;
import com.example.farm_goods_service.Model.Goods;
import com.example.farm_goods_service.Repositery.GoodsRepository;
import com.example.farm_goods_service.dto.GoodsRequestDto;
import com.example.farm_goods_service.dto.GoodsResponseDto;
import com.example.farm_goods_service.exception.GoodsNotFoundException;
import com.example.farm_goods_service.grpc.GoodsServiceGrpcClient;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class GoodsService {
    private final GoodsRepository goodsRepository;
    private GoodsServiceGrpcClient goodsServiceGrpcClient;

    public GoodsService(GoodsRepository goodsRepository,GoodsServiceGrpcClient goodsServiceGrpcClient) {
        this.goodsRepository = goodsRepository;
        this.goodsServiceGrpcClient = goodsServiceGrpcClient;
    }

    public List<GoodsResponseDto> getGoods() {
        List<Goods> goodsList = goodsRepository.findAll();
        List<goods.GoodsRequest> grpcGoodsRequest = goodsList.stream().map(g->
                goods.GoodsRequest.newBuilder()
                        .setProductName(g.getProductName())
                        .setProductType(g.getProductType())
                        .setUnitPrice(g.getUnitPrice())
                        .setQuantityAvailable(g.getQuantityAvailable())
                        .setExpiryDate(g.getExpiryDate().toString())
                        .setHarvestDate(g.getHarvestDate().toString()).build()).toList();
        goodsServiceGrpcClient.fetchAllGoods(grpcGoodsRequest);
        return goodsList.stream()
                .map(GoodsMapper::toDto)
                .toList();
    }
    public Account getAccount(){
        List<Goods> goodsList = goodsRepository.findAll();
        List<goods.GoodsRequest> grpcGoodsRequest = goodsList.stream().map(g->
                goods.GoodsRequest.newBuilder()
                        .setProductName(g.getProductName())
                        .setProductType(g.getProductType())
                        .setUnitPrice(g.getUnitPrice())
                        .setQuantityAvailable(g.getQuantityAvailable())
                        .setExpiryDate(g.getExpiryDate().toString())
                        .setHarvestDate(g.getExpiryDate().toString()).build()).toList();
        return goodsServiceGrpcClient.fetchAllGoods(grpcGoodsRequest);
    }

    public GoodsResponseDto createGoods(GoodsRequestDto goodsRequestDto) {
        Goods newGoods = goodsRepository.save(GoodsMapper.toModel(goodsRequestDto));
        goodsServiceGrpcClient.createNewGoods(newGoods.getProductName(), newGoods.getProductType(), newGoods.getQuantityAvailable(),
                newGoods.getUnitPrice(), newGoods.getHarvestDate().toString(),newGoods.getExpiryDate().toString());
        return GoodsMapper.toDto(newGoods);
    }

    @Transactional
    public GoodsResponseDto updateGoods(UUID id, GoodsRequestDto goodsRequestDto) {
        Goods goods = goodsRepository.findById(id)
                .orElseThrow(() -> new GoodsNotFoundException("Goods not found with Id " + id));

        goods.setProductName(goodsRequestDto.getProductName());
        goods.setProductType(goodsRequestDto.getProductType());
        goods.setQuantityAvailable(goodsRequestDto.getQuantityAvailable());
        goods.setUnitPrice(goodsRequestDto.getUnitPrice());
        goods.setHarvestDate(LocalDate.parse(goodsRequestDto.getHarvestDate()));
        goods.setExpiryDate(LocalDate.parse(goodsRequestDto.getExpiryDate()));

        Goods updatedGoods = goodsRepository.save(goods);
        return GoodsMapper.toDto(updatedGoods);
    }

    public void deleteGoods(UUID id) {
        goodsRepository.deleteById(id);
    }
}
