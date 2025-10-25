package com.example.Farmer_Service.grpc;

import com.example.Farmer_Service.Repositery.CustomerRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import orders.CustomerId;
import orders.ExistOrNot;
import orders.orderGoodsGrpc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;
@GrpcService
public class OrderCheckCustomerGrpcService extends orderGoodsGrpc.orderGoodsImplBase {
    private static final Logger log = LoggerFactory.getLogger(OrderCheckCustomerGrpcService.class);
    private CustomerRepository customerRepository;

    public OrderCheckCustomerGrpcService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void takeNewOrderFromCustomerId(CustomerId request, StreamObserver<ExistOrNot> responseObserver) {
        log.info("CustomerId received {}", request.toString());
        ExistOrNot response;
        if (customerRepository.existsById(UUID.fromString(request.getId()))) {
            response = ExistOrNot.newBuilder().setMessage("Provided customer Id exist in the list").build();
        } else {
            response = ExistOrNot.newBuilder().setMessage("Provided customer Id not exist in the list").build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}