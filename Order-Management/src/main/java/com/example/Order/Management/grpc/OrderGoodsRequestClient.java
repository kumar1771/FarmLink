package com.example.Order.Management.grpc;

import com.example.Order.Management.dto.GoodsItemDto;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import orders.Goods;
import orders.GoodsExist;
import orders.OrdersFromCustomer;
import orders.orderGoodsGrpc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderGoodsRequestClient {
    private static final Logger log = LoggerFactory.getLogger(OrderGoodsRequestClient.class);
    public final orderGoodsGrpc.orderGoodsBlockingStub blockingStub;

    public OrderGoodsRequestClient(
            @Value("${orders.service.address:localhost}") String serverAddress,
            @Value("${orders.service.grpc.port:9002}")int serverPort
    ) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(serverAddress,serverPort).usePlaintext().build();
        blockingStub = orderGoodsGrpc.newBlockingStub(channel);
    }
    public GoodsExist GoodsPresence(List<GoodsItemDto> goods){
        OrdersFromCustomer.Builder orders = OrdersFromCustomer.newBuilder();
        for(GoodsItemDto dto : goods) {
            Goods goodsProto = Goods.newBuilder()
                    .setGoodId(dto.getGoodsId().toString())
                    .setQuantity(dto.getQuantity())
                    .setPrice(dto.getPrice()).build();
            orders.addListOfGoods(goodsProto);
        }
        OrdersFromCustomer request = orders.build();
        GoodsExist response = blockingStub.takeNNumbersOfOrdersFromCustomer(request);
        return response;
    }
}
