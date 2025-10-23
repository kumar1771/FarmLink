package com.example.Farmer_Service.Service;

import com.example.Farmer_Service.Mapper.CustomerMapper;
import com.example.Farmer_Service.Model.Customers;
import com.example.Farmer_Service.Model.Goods;
import com.example.Farmer_Service.Repositery.CustomerRepository;
import com.example.Farmer_Service.dto.CustomerRequestDto;
import com.example.Farmer_Service.dto.CustomerResponseDto;
import com.example.Farmer_Service.exception.CustomerNotFoundException;
import com.example.Farmer_Service.exception.EmailAlreadyExistException;
//import com.example.Farmer_Service.grpc.GoodsGrpcClient;
import com.example.Farmer_Service.grpc.FarmerGrpcClient;
import com.example.Farmer_Service.grpc.CustomersGrpcService;
import com.example.Farmer_Service.grpc.FarmerGrpcClient2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {
    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);
    private CustomerRepository customerRepository;
    private CustomersGrpcService goodsGrpcService;
    private FarmerGrpcClient farmerGrpcClient;
    private FarmerGrpcClient2 farmerGrpcClient2;

    public CustomerService(CustomerRepository customerRepository, CustomersGrpcService goodsGrpcService, FarmerGrpcClient farmerGrpcClient, FarmerGrpcClient2 farmerGrpcClient2) {
        this.customerRepository = customerRepository;
        this.goodsGrpcService = goodsGrpcService;
        this.farmerGrpcClient = farmerGrpcClient;
        this.farmerGrpcClient2 = farmerGrpcClient2;
    }

//    public List<Goods> getGoods() {
//        goods.GoodsList grpcGoodsList = goodsGrpcService.getGoodsFromServer();
//    }
    public List<CustomerResponseDto> getcustomers(){
        List<Customers> customers = customerRepository.findAll();
        List<CustomerResponseDto> customerResponseDtos = customers.stream().map(CustomerMapper::toDo).toList();
        return customerResponseDtos;
    }
    public CustomerResponseDto CreateCustomer(CustomerRequestDto customerRequestDto){
        if(customerRepository.existsByEmail(customerRequestDto.getEmail())){
            throw new EmailAlreadyExistException("A Customer with this mail"+customerRequestDto.getEmail()+" already exist");
        }
        Customers newCustomer = customerRepository.save(CustomerMapper.toModel(customerRequestDto));
        return CustomerMapper.toDo(newCustomer);
    }
    public CustomerResponseDto UpdateCustomer(UUID id,CustomerRequestDto customerRequestDto){
        Customers customers = customerRepository.findById(id).orElseThrow(()->new CustomerNotFoundException("Customer not found with Id "+id));
        customers.setName(customerRequestDto.getName());
        customers.setAddress(customerRequestDto.getAddress());
        customers.setEmail(customerRequestDto.getEmail());
        customers.setDateOfBirth(LocalDate.parse(customerRequestDto.getDateOfBirth()));
        Customers updatedCustomer = customerRepository.save(customers);
        return CustomerMapper.toDo(updatedCustomer);
    }
    public void DeleteCustomer(UUID id){
        customerRepository.deleteById(id);
    }
    public List<Goods> getCustomerRequest(UUID id){
        Customers customers = customerRepository.findById(id).orElseThrow(()->new CustomerNotFoundException("Customer not found with Id "+id));
        goods.ListOfGoods grpcGoods = farmerGrpcClient.getGoodsFromServer(customers.getId().toString(),customers.getName());
        List<Goods> goods = grpcGoods.getGoodsForCustomerRequestList().stream().map(g->new Goods(UUID.fromString(g.getId()),g.getProductName(),g.getProductType()
        ,g.getQuantityAvailable(),g.getUnitPrice(),LocalDate.parse(g.getHarvestDate()),LocalDate.parse(g.getExpiryDate()))).toList();
        return goods;
    }
    public String validateUuid(UUID customerId,UUID goodsId,int quantity){
        Customers customers = customerRepository.findById(customerId).orElseThrow(()->new CustomerNotFoundException("Customer not found with Id "+customerId));
        goods.ListOfGoods grpcGoods = farmerGrpcClient.getGoodsFromServer(customers.getId().toString(),customers.getName());

//        System.out.println("Happy to say"+grpcGoods.toString()+"Happy to say");
//        if(grpcGoods.getGoodsForCustomerRequestList().stream()
//                .anyMatch(g -> UUID.fromString(g.getId()).equals(id))){
//        }
//        List<goods.GoodsResponse> grpcGoods1 = grpcGoods.getGoodsForCustomerRequestList();
//        for(int i=0;i<grpcGoods1.size();i++)
        for(var g : grpcGoods.getGoodsForCustomerRequestList()){
            if(UUID.fromString(g.getId()).equals(goodsId)){
                Goods goods1 = new Goods(
                        UUID.fromString(g.getId()),
                        g.getProductName(),
                        g.getProductType(),
                        g.getQuantityAvailable(),
                        g.getUnitPrice(),
                        LocalDate.parse(g.getHarvestDate()),
                        LocalDate.parse(g.getExpiryDate())
                );
//                log.info("Happy to say"+ goods1.toString()+"Happy to say");
                farmerGrpcClient.editeGoodsInGoodsService(UUID.fromString(g.getId()),
                        goods1.getProductName(),
                        goods1.getProductType(),
                        goods1.getQuantityAvailable()-quantity,
                        goods1.getUnitPrice(),
                        goods1.getHarvestDate(),
                        goods1.getExpiryDate());
                farmerGrpcClient2.OrderDetails(customers.getId(), customers.getEmail(), UUID.fromString(g.getId()),quantity,quantity*g.getUnitPrice());
                return "Order successfully : %.2f"+ quantity;
            }
        }
        // If no matching goods found, throw exception
        throw new RuntimeException("Goods with ID " + goodsId + " not found for the customer");
    }
}
