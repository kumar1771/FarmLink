package com.example.farm_goods_service.Repositery;

import com.example.farm_goods_service.Model.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GoodsRepository extends JpaRepository<Goods, UUID> {

}
