package com.example.Auth_Service.Repositery;

import com.example.Auth_Service.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserRepo extends JpaRepository<User, UUID> {
    Boolean existsByEmail(String email);
    Optional<User>findByEmail(String email);
}
