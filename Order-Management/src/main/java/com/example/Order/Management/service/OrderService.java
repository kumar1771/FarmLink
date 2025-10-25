package com.example.Order.Management.service;

import com.example.Order.Management.Method.GoodsItem;
import com.example.Order.Management.Method.Order;
import com.example.Order.Management.Method.OrderRequest;
import com.example.Order.Management.Repository.GoodsItemRepository;
import com.example.Order.Management.Repository.OrderRepository;
import com.example.Order.Management.Repository.OrderRequestRepository;
import com.example.Order.Management.dto.GoodsItemDto;
import com.example.Order.Management.dto.OrderRequestDto;
import com.example.Order.Management.grpc.OrderCustomerRequestClient;
import com.example.Order.Management.grpc.OrderGoodsRequestClient;
import com.example.Order.Management.kafka.kafkaProducer1;
import orders.ExistOrNot;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private kafkaProducer1 kafkaProducer;
    private JavaMailSender javaMailSender;
    private OrderGoodsRequestClient orderGoodsRequestClient;
    private OrderCustomerRequestClient orderCustomerRequestClient;
    private GoodsItemRepository goodsItemRepository;
    private OrderRequestRepository orderRequestRepository;

    public OrderService(OrderRepository orderRepository, kafkaProducer1 kafkaProducer, JavaMailSender javaMailSender, OrderGoodsRequestClient orderGoodsRequestClient, OrderCustomerRequestClient orderCustomerRequestClient, GoodsItemRepository goodsItemRepository, OrderRequestRepository orderRequestRepository) {
        this.orderRepository = orderRepository;
        this.kafkaProducer = kafkaProducer;
        this.javaMailSender = javaMailSender;
        this.orderGoodsRequestClient = orderGoodsRequestClient;
        this.orderCustomerRequestClient = orderCustomerRequestClient;
        this.goodsItemRepository = goodsItemRepository;
        this.orderRequestRepository = orderRequestRepository;
    }
    public List<Order> getOrdersList(){
        List<Order> order = orderRepository.findAll();
        return order;
    }
    public Order GetNewOrder(Order order){
        Order order1 = orderRepository.save(order);
        kafkaProducer.sendOrderDetails(order1);
        return order1;
    }

    public Order updateOrder(UUID id, Order order2) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
        order.setCustomerId(order2.getCustomerId());
        order.setGoodsId(order2.getGoodsId());
        order.setQuantity(order2.getQuantity());
        order.setTotalPrice(order2.getTotalPrice());
        order.setStatus(order2.getStatus());
        order.setOrderDate(order2.getOrderDate());

        return orderRepository.save(order);
    }
    public void deleteOrder(UUID id) {
        orderRepository.deleteById(id);
    }
    public void sendMail(String to, String subject, String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        javaMailSender.send(message);
    }
    @Transactional
    public ExistOrNot orderGoods(OrderRequestDto orderRequestDto) {
        List<GoodsItemDto> goods = orderRequestDto.getGoods();
        System.out.println(orderGoodsRequestClient.GoodsPresence(goods).toString());
        System.out.println(orderCustomerRequestClient.customerPresence(orderRequestDto.getCustomerId().toString()).toString());
        String goodsMsg = orderGoodsRequestClient.GoodsPresence(goods).getMessage();
        String customerMsg = orderCustomerRequestClient.customerPresence(orderRequestDto.getCustomerId().toString()).getMessage();
        if("✅ All goods are available.".equals(goodsMsg) && "Provided customer Id exist in the list".equals(customerMsg)){
            OrderRequest orderRequest = new OrderRequest();
            orderRequest.setCustomerId(orderRequestDto.getCustomerId());
            orderRequest.setOrderDate(LocalDateTime.now());
            orderRequest.setStatus("Order placed");
            List<GoodsItem> nGoods = new ArrayList<>();
            for(GoodsItemDto good : orderRequestDto.getGoods()){
                GoodsItem item = new GoodsItem();
                item.setGoodsId(good.getGoodsId());
                item.setQuantity(good.getQuantity());
                item.setPrice(good.getPrice());
                item.setOrder(orderRequest);
                nGoods.add(item);
            }
            orderRequest.setItem(nGoods);
            orderRequestRepository.save(orderRequest);
            return ExistOrNot.newBuilder().setMessage("Order placed").build();
        }else{
            return ExistOrNot.newBuilder().setMessage("Order Not placed").build();
        }
    }

}
