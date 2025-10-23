package com.example.Farmer_Service.grpc;

import com.example.Farmer_Service.Model.Goods;
import goods.FarmerGoodsServiceGrpc;
import goods.ListOfGoods;
import goods.OrderRequest;
import goods.OrderResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class FarmerGrpcClient {
    public static final Logger log = LoggerFactory.getLogger(FarmerGrpcClient.class);
    public final FarmerGoodsServiceGrpc.FarmerGoodsServiceBlockingStub blockingStub;
    public FarmerGrpcClient(
            @Value("${goods.service.address:localhost}")String serverAddress,
            @Value("${goods.service.grpc.port:9002}")int serverPort
    ){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(serverAddress,serverPort).usePlaintext().build();
        blockingStub = FarmerGoodsServiceGrpc.newBlockingStub(channel);
    }
    public ListOfGoods getGoodsFromServer(String customerId, String customerName){
        goods.CustomerDetails request = goods.CustomerDetails.newBuilder()
                .setCustomerId(customerId).setCustomerName(customerName).build();
        ListOfGoods response = blockingStub.customerRequest(request);
        return response;
    }
    public ListOfGoods editeGoodsInGoodsService(UUID id, String productName, String productType, Integer quantityAvailable
    , Double unitPrice, LocalDate harvestDate,LocalDate expiryDate){
        goods.GoodsRequest goodsRequest = goods.GoodsRequest.newBuilder()
                .setId(id.toString())
                .setProductName(productName)
                .setProductType(productType)
                .setQuantityAvailable(quantityAvailable)
                .setUnitPrice(unitPrice)
                .setHarvestDate(harvestDate.toString())
                .setExpiryDate(expiryDate.toString()).build();
        ListOfGoods response = blockingStub.editeGoods(goodsRequest);
        System.out.println(response.toString());
        return response;
    }
    public OrderResponse OrderDetails(UUID customerId, UUID goodsId, Integer quantity,
    double totalPrice){
        OrderRequest orderRequest = OrderRequest.newBuilder()
                .setCustomerId(customerId.toString())
                .setGoodsId(goodsId.toString())
                .setQuantity(quantity)
                .setTotalPrice(totalPrice).build();
        OrderResponse response = blockingStub.orderGoods(orderRequest);
        return response;
    }
}
