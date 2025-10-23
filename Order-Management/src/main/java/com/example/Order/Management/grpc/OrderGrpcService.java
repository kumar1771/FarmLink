package com.example.Order.Management.grpc;

import com.example.Order.Management.Method.Order;
import com.example.Order.Management.service.OrderService;
import goods.FarmerGoodsServiceGrpc;
import goods.OrderRequest;
import goods.OrderResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@GrpcService
public class OrderGrpcService extends FarmerGoodsServiceGrpc.FarmerGoodsServiceImplBase {
    private OrderService orderService;

    public OrderGrpcService(OrderService orderService) {
        this.orderService = orderService;
    }

    public static final Logger log = LoggerFactory.getLogger(OrderGrpcService.class);
    @Override
    public void orderGoods(OrderRequest request, StreamObserver<OrderResponse> responseObserver){
        log.info("New Order request received : {}",request.toString());
        Order order = new Order(UUID.fromString(request.getCustomerId()), request.getEmail() ,UUID.fromString(request.getGoodsId()),
                request.getQuantity(), request.getTotalPrice(), "Conformed", LocalDateTime.now());
        orderService.GetNewOrder(order);
        OrderResponse response = OrderResponse.newBuilder().setOrderId(order.getOrderId().toString())
                .setOrderDetails(order.getStatus()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
