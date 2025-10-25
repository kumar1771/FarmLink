package com.example.farm_goods_service.grpc;

import com.example.farm_goods_service.Repositery.GoodsRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import orders.Goods;
import orders.GoodsExist;
import orders.OrdersFromCustomer;
import orders.orderGoodsGrpc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@GrpcService
public class OrderCheckGoodsGrpcService extends orderGoodsGrpc.orderGoodsImplBase{
    private static final Logger log = LoggerFactory.getLogger(OrderCheckGoodsGrpcService.class);
    private GoodsRepository goodsRepository;

    public OrderCheckGoodsGrpcService(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    @Override
    public void takeNNumbersOfOrdersFromCustomer(OrdersFromCustomer request, StreamObserver<GoodsExist> responseObserver){
        log.info("GoodsList received {}",request.toString());
        GoodsExist response;
        List<Goods> listOfGoods = request.getListOfGoodsList();
        List<Goods> unAvailableGoods = new ArrayList<>();
        for(Goods goods:listOfGoods){
            log.info("received good {}",goods.getGoodId());
            if(!goodsRepository.existsById(UUID.fromString(goods.getGoodId()))){
                unAvailableGoods.add(goods);
            }
        }
        if(unAvailableGoods.isEmpty()){
            response = GoodsExist.newBuilder().setMessage("✅ All goods are available.").build();
        }
        else {
            response = GoodsExist.newBuilder()
                    .setMessage("❌ Unavailable goods: " + String.join(", ", unAvailableGoods.toString()))
                    .build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
        log.info("Goods verification completed: {}", response.getMessage());
    }
}
