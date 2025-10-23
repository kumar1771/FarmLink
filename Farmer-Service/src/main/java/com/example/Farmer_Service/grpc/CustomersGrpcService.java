package com.example.Farmer_Service.grpc;

import goods.FarmerGoodsServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class CustomersGrpcService extends FarmerGoodsServiceGrpc.FarmerGoodsServiceImplBase {
    private static final Logger log = LoggerFactory.getLogger(CustomersGrpcService.class);
    @Override
    public void createNewGoods(goods.GoodsRequest request, StreamObserver<goods.GoodsResponse> responseObserver){
        log.info("createNewGoods request received {} ",request.toString());
        goods.GoodsResponse response = goods.GoodsResponse.newBuilder()
                .setProductName(request.getProductName())
                .setProductType(request.getProductType())
                .setQuantityAvailable(request.getQuantityAvailable())
                .setUnitPrice(request.getUnitPrice())
                .setExpiryDate(request.getExpiryDate())
                .setHarvestDate(request.getHarvestDate()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    @Override
    public void pushGoodsBatch(goods.FGoodsList request, StreamObserver<goods.GoodsList> responseObserver){
        log.info("Received goods List {} ",request.getGoodsList());
        goods.GoodsList response = goods.GoodsList.newBuilder()
                .setAccountNumber(512212)
                .setAccountName("Pavan Kumar").build();
        System.out.println(response.toString());
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
//    public List<Goods> getGoodsFromServer(goods.FGoodsList request){
//        return request.getGoodsList().stream().map(g->new Goods(g.getProductName(),
//                g.getProductType(),g.getQuantityAvailable(),g.getUnitPrice(), LocalDate.parse(g.getHarvestDate()),
//                LocalDate.parse(g.getExpiryDate()))).toList();
//    }
}
