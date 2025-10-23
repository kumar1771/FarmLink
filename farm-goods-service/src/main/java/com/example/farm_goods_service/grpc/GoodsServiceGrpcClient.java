package com.example.farm_goods_service.grpc;

import com.example.farm_goods_service.Model.Account;
import goods.FGoodsList;
import goods.FarmerGoodsServiceGrpc;
import goods.GoodsList;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class GoodsServiceGrpcClient {
    public static final Logger log = LoggerFactory.getLogger(GoodsServiceGrpcClient.class);
    private final FarmerGoodsServiceGrpc.FarmerGoodsServiceBlockingStub blockingStub;
    public GoodsServiceGrpcClient(
            @Value("${goods.service.address:localhost}")String serverAddress,
            @Value("${goods.service.grpc.port:9001}")int serverPort
    ){
        log.info("Connecting to goods service grpc service at {} : {}",serverAddress,serverPort);
        ManagedChannel channel = ManagedChannelBuilder.forAddress(serverAddress,serverPort).usePlaintext().build();
        blockingStub = FarmerGoodsServiceGrpc.newBlockingStub(channel);
    }
    public goods.GoodsResponse createNewGoods(String productName,
    String productType,
    Integer quantityAvailable,
    double unitPrice,
    String harvestDate,
    String expiryDate){
        goods.GoodsRequest request = goods.GoodsRequest.newBuilder()
                .setProductName(productName)
                .setProductType(productType)
                .setQuantityAvailable(quantityAvailable)
                .setUnitPrice(unitPrice)
                .setHarvestDate(harvestDate)
                .setExpiryDate(expiryDate).build();
        goods.GoodsResponse response = blockingStub.createNewGoods(request);
        log.info("Received response from goods service via GRPC {} ",response);
        return response;
    }
    public Account fetchAllGoods(List<goods.GoodsRequest> goodsRequests){
        log.info("Fetching all goods from Goods service");
        FGoodsList request = FGoodsList.newBuilder().addAllGoods(goodsRequests).build();
        goods.GoodsList response = blockingStub.pushGoodsBatch(request);
        log.info("Received {} goods from Goods service", response);
        Account account = new Account(response.getAccountNumber(), response.getAccountName());
        return account;
    }
//    public goods.GoodsList createAccount(List<goods.GoodsRequest> goodsRequests){
//        FGoodsList request = FGoodsList.newBuilder().addAllGoods(goodsRequests).build();
//        goods.GoodsList response = blockingStub.pushGoodsBatch(request);
//    }
}
