package com.example.Farmer_Service.Mapper;

import com.example.Farmer_Service.Model.Customers;
import com.example.Farmer_Service.dto.CustomerRequestDto;
import com.example.Farmer_Service.dto.CustomerResponseDto;

import java.time.LocalDate;

public class CustomerMapper {
    public static CustomerResponseDto toDo(Customers customers){
        CustomerResponseDto customResponse = new CustomerResponseDto();
        customResponse.setId(customers.getId().toString());
        customResponse.setAddress(customers.getAddress());
        customResponse.setName(customers.getName());
        customResponse.setDateOfBirth(customers.getDateOfBirth().toString());
        customResponse.setEmail(customers.getEmail());
        return customResponse;
    }
    public static Customers toModel(CustomerRequestDto customerRequestDto){
        Customers customers = new Customers();
        customers.setAddress(customerRequestDto.getAddress());
        customers.setEmail(customerRequestDto.getEmail());
        customers.setName(customerRequestDto.getName());
        customers.setDateOfBirth(LocalDate.parse(customerRequestDto.getDateOfBirth()));
        customers.setRegisteredDate(LocalDate.parse(customerRequestDto.getRegisteredDate()));
        return customers;
    }
}
