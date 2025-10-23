package com.example.Order.Management.kafka;

import com.example.Order.Management.service.OrderService;
import com.google.protobuf.InvalidProtocolBufferException;
import order.details.OrderDetails;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class kafkaConsumer {
    private OrderService orderService;

    public kafkaConsumer(OrderService orderService) {
        this.orderService = orderService;
    }

    private static final Logger log = LoggerFactory.getLogger(kafkaConsumer.class);
    @KafkaListener(topics = "orders", groupId = "Notification - service - group")
    public void consumeOrder(ConsumerRecord<String,byte[]> record){
        try{
            OrderDetails orderDetails = OrderDetails.parseFrom(record.value());
            String email = orderDetails.getEmail();
            String message = String.format("Your order %s for goods %s of quantity %d has been placed successfully. Total: %.2f",
            orderDetails.getOrderId(), orderDetails.getGoodsId(), orderDetails.getQuantity(), orderDetails.getTotalPrice());
            String subject = orderDetails.getStatus();
            orderService.sendMail(email,subject,message);
            log.info("Order successfully placed {}",orderDetails);
        }catch(InvalidProtocolBufferException e){
            log.info("❌ Failed to parse OrderDetails from Kafka message", e);
        }
    }
}
