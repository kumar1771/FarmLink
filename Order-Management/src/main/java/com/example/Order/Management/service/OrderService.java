package com.example.Order.Management.service;

import com.example.Order.Management.Method.Order;
import com.example.Order.Management.Repository.OrderRepository;
import com.example.Order.Management.kafka.kafkaProducer1;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private kafkaProducer1 kafkaProducer;
    private JavaMailSender javaMailSender;

    public OrderService(OrderRepository orderRepository, kafkaProducer1 kafkaProducer, JavaMailSender javaMailSender) {
        this.orderRepository = orderRepository;
        this.kafkaProducer = kafkaProducer;
        this.javaMailSender = javaMailSender;
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
}
