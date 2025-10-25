package com.example.Order.Management.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import orders.CustomerId;
import orders.ExistOrNot;
import orders.orderGoodsGrpc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderCustomerRequestClient {
    public static final Logger log = LoggerFactory.getLogger(OrderCustomerRequestClient.class);
    public final orderGoodsGrpc.orderGoodsBlockingStub blockingStub;

    public OrderCustomerRequestClient(
            @Value("${orders.service.address:localhost}") String serverAddress,
            @Value("${orders.service.grpc.port:9001}") int serverPort
    ){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(serverAddress, serverPort).usePlaintext().build();
        blockingStub = orderGoodsGrpc.newBlockingStub(channel);
    }
    public ExistOrNot customerPresence(String customerId){
        CustomerId request = CustomerId.newBuilder().setId(customerId).build();
        ExistOrNot response = blockingStub.takeNewOrderFromCustomerId(request);
        return response;
    }
}
