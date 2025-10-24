package com.example.Order.Management.Controller;

import com.example.Order.Management.Method.Order;
import com.example.Order.Management.dto.OrderRequestDto;
import com.example.Order.Management.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Order")
@Tag(name = "Orders", description = "API for managing orders")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping
    @Operation(summary = "Getting all order details")
    public ResponseEntity<List<Order>> getOrdersList(){
        List<Order> order = orderService.getOrdersList();
        return ResponseEntity.ok().body(order);
    }
    @PostMapping
    @Operation(summary = "Getting new order")
    public ResponseEntity<Order> getOrder(@RequestBody Order order){
        Order order1 = orderService.GetNewOrder(order);
        return ResponseEntity.ok().body(order1);
    }
    @PutMapping("/{id}")
    @Operation(summary = "Update an existing order")
    public ResponseEntity<Order> updateOrder(@PathVariable UUID id, @RequestBody Order order) {
        Order updatedOrder = orderService.updateOrder(id, order);
        return ResponseEntity.ok().body(updatedOrder);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an order by ID")
    public ResponseEntity<Void> deleteOrder(@PathVariable UUID id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping
    public String orderGoods(@RequestBody OrderRequestDto orderRequestDto){
        Boolean k = orderService.orderGoods(orderRequestDto);
    }
}
