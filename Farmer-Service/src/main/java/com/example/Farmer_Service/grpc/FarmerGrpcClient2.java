package com.example.Farmer_Service.grpc;

import goods.FarmerGoodsServiceGrpc;
import goods.OrderRequest;
import goods.OrderResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class FarmerGrpcClient2 {
    public static final Logger log = LoggerFactory.getLogger(FarmerGrpcClient2.class);
    public final FarmerGoodsServiceGrpc.FarmerGoodsServiceBlockingStub blockingStub;
    public FarmerGrpcClient2(
            @Value("${order.service.address:localhost}")String serverAddress,
            @Value("${order.server.grpc.port:9003}")int serverPort
    ){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(serverAddress,serverPort).usePlaintext().build();
        blockingStub = FarmerGoodsServiceGrpc.newBlockingStub(channel);
    }
    public OrderResponse OrderDetails(UUID customerId, String email , UUID goodsId, Integer quantity,
                                      double totalPrice){
        OrderRequest orderRequest = OrderRequest.newBuilder()
                .setCustomerId(customerId.toString())
                .setEmail(email)
                .setGoodsId(goodsId.toString())
                .setQuantity(quantity)
                .setTotalPrice(totalPrice).build();
        OrderResponse response = blockingStub.orderGoods(orderRequest);
        return response;
    }
}
