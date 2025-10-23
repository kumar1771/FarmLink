package com.example.Farmer_Service.Contoller;

import com.example.Farmer_Service.Model.Goods;
import com.example.Farmer_Service.Service.CustomerService;
import com.example.Farmer_Service.dto.CustomerRequestDto;
import com.example.Farmer_Service.dto.CustomerResponseDto;
import com.example.Farmer_Service.grpc.FarmerGrpcClient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
@Tag(name = "customers", description = "API for managing customers")
public class CustomerController {
    private CustomerService customerService;
    private FarmerGrpcClient farmerGrpcClient;

    public CustomerController(CustomerService customerService,FarmerGrpcClient farmerGrpcClient) {
        this.customerService = customerService;
        this.farmerGrpcClient = farmerGrpcClient;
    }
//    @GetMapping("/goods")
//    @Operation(summary = "Received goods from server")
//    public ResponseEntity<List<Goods>> getGoods(){
//        goods.ListOfGoods grpcGoods = farmerGrpcClient.getGoodsFromServer()
//    }
    @GetMapping("/goods/{id}")
    @Operation(summary = "Request server for data")
    public ResponseEntity<List<Goods>> getCustomerRequest(@PathVariable UUID id){
        List<Goods> goods = customerService.getCustomerRequest(id);
        return ResponseEntity.ok().body(goods);
    }
    @GetMapping
    @Operation(summary = "Get customers details")
    public ResponseEntity<List<CustomerResponseDto>> GetCustomers(){
        List<CustomerResponseDto> customers = customerService.getcustomers();
        return ResponseEntity.ok().body(customers);
    }
    @PostMapping
    @Operation(summary = "post customer details")
    public ResponseEntity<CustomerResponseDto> CreateCustomer(@RequestBody CustomerRequestDto customerRequestDto){
        CustomerResponseDto customerResponseDto = customerService.CreateCustomer(customerRequestDto);
        return ResponseEntity.ok().body(customerResponseDto);
    }
    @PutMapping("/{id}")
    @Operation(summary = "update customer details")
    public ResponseEntity<CustomerResponseDto> updateCustomer(@PathVariable UUID id,@Validated({Default.class}) @RequestBody CustomerRequestDto customerRequestDto){
        CustomerResponseDto customerResponseDto = customerService.UpdateCustomer(id,customerRequestDto);
        return ResponseEntity.ok().body(customerResponseDto);
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Remove customer details")
    public ResponseEntity<Void> deleteCustomer(@PathVariable UUID id){
        customerService.DeleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/goods/{id}")
    @Operation(summary = "order goods")
    public ResponseEntity<Void> orderGoods(@PathVariable UUID id, @RequestBody Goods goods,@RequestParam int quantity){
        customerService.validateUuid(id,goods.getId(),quantity);
        return ResponseEntity.noContent().build();
    }
}
