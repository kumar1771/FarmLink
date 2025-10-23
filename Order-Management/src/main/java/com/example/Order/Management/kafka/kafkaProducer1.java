package com.example.Order.Management.kafka;

import com.example.Order.Management.Method.Order;
import order.details.OrderDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class kafkaProducer1 {
    private static final Logger log = LoggerFactory.getLogger(kafkaProducer1.class);
    private final KafkaTemplate<String,byte[]> kafkaTemplate;

    public kafkaProducer1(KafkaTemplate<String, byte[]> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendOrderDetails(Order order){
        OrderDetails orderDetails = OrderDetails.newBuilder()
                .setOrderId(order.getOrderId().toString())
                .setEmail(order.getEmail())
                .setGoodsId(order.getGoodsId().toString())
                .setQuantity(order.getQuantity())
                .setTotalPrice(order.getTotalPrice())
                .setStatus(order.getStatus())
                .setOrderDate(order.getOrderDate().toString()).build();
        try{
            kafkaTemplate.send("orders", orderDetails.toByteArray());
        }catch (Exception e){
            log.error("Error sending Order Details {}",orderDetails);
        }
    }
}
