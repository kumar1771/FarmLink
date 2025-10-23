package com.example.farm_goods_service.grpc;

import com.example.farm_goods_service.Service.GoodsService;
import com.example.farm_goods_service.dto.GoodsRequestDto;
import com.example.farm_goods_service.dto.GoodsResponseDto;
import goods.FarmerGoodsServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@GrpcService
public class GoodsGrpcService extends FarmerGoodsServiceGrpc.FarmerGoodsServiceImplBase {
    private static final Logger log = LoggerFactory.getLogger(GoodsGrpcService.class);
    private GoodsService goodsService;

    public GoodsGrpcService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @Override
    public void customerRequest(goods.CustomerDetails request, StreamObserver<goods.ListOfGoods> responseObserver) {
        log.info("A rest has been received from customer : {} ", request.toString());
        List<GoodsResponseDto> goodsResponse = goodsService.getGoods();
        goods.ListOfGoods response = goods.ListOfGoods.newBuilder().addAllGoodsForCustomerRequest(
                goodsResponse.stream().map(g -> goods.GoodsResponse.newBuilder()
                        .setId(g.getId())
                        .setProductName(g.getProductName())
                        .setProductType(g.getProductType())
                        .setUnitPrice(g.getUnitPrice())
                        .setQuantityAvailable(g.getQuantityAvailable())
                        .setExpiryDate(g.getExpiryDate())
                        .setHarvestDate(g.getHarvestDate()).build()).toList()
        ).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void editeGoods(goods.GoodsRequest request, StreamObserver<goods.ListOfGoods> responseObserver) {
        log.info("A request has been received from customer to make changes in goods : {}", request.toString());

        UUID id = UUID.fromString(request.getId());
        GoodsRequestDto goodsRequestDto = new GoodsRequestDto(request.getProductName(),
                request.getProductType(),
                request.getQuantityAvailable(),
                request.getUnitPrice(),
                request.getHarvestDate(),
                request.getExpiryDate());

        goodsService.updateGoods(id, goodsRequestDto);  // update first

        List<GoodsResponseDto> goodsResponse = goodsService.getGoods();  // fetch updated data

        goods.ListOfGoods response = goods.ListOfGoods.newBuilder().addAllGoodsForCustomerRequest(
                goodsResponse.stream().map(g -> goods.GoodsResponse.newBuilder()
                        .setId(g.getId())
                        .setProductName(g.getProductName())
                        .setProductType(g.getProductType())
                        .setUnitPrice(g.getUnitPrice())
                        .setQuantityAvailable(g.getQuantityAvailable())
                        .setExpiryDate(g.getExpiryDate())
                        .setHarvestDate(g.getHarvestDate())
                        .build()).toList()
        ).build();

        log.info("Updated goods data in db : {}", response);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}