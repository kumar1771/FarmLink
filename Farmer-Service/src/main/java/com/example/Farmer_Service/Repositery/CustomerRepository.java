package com.example.Farmer_Service.Repositery;

import com.example.Farmer_Service.Model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, UUID>{
    Boolean existsByEmail(String email);
    Boolean existsByEmailAndIdNot(String email, UUID id);
}
