package com.example.Auth_Service.Service;

import com.example.Auth_Service.Enum.role;
import com.example.Auth_Service.Model.TokenValidationResponse;
import com.example.Auth_Service.Model.User;
import com.example.Auth_Service.Repositery.UserRepo;
import com.example.Auth_Service.Util.JwtUtil;
import com.example.Auth_Service.dto.LoginReqDto;
import com.example.Auth_Service.dto.LoginResDto;
import com.example.Auth_Service.dto.SignUpDto;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;

    public String SignUp(SignUpDto signUp) {
        try {
            if (userRepo.existsByEmail(signUp.getEmail())) {
                throw new RuntimeException("Email already exist");
            }
            User user = new User();
            user.setPassword(passwordEncoder.encode(signUp.getPassword()));
            user.setEmail(signUp.getEmail());
            user.setUserRole(role.valueOf(signUp.getRole().toUpperCase()));
            userRepo.save(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Profile created successfully";
    }

    public LoginResDto Login(LoginReqDto login) {
        String uEmail = login.getEmail();
        Optional<User> existingUser = userRepo.findByEmail(uEmail);
        String loginPassword = login.getPassword();
        try {
            if (existingUser.isPresent()) {
                String ExistingPassword = existingUser.get().getPassword();
                String ExistingRole = existingUser.get().getUserRole().toString();
                if (passwordEncoder.matches(loginPassword, ExistingPassword)) {
                    String token = jwtUtil.generateToken(uEmail, ExistingRole);
                    LoginResDto loginResDto = new LoginResDto();
                    loginResDto.setAccessToken(token);
                    loginResDto.setStatus("Success");
                    return loginResDto;
                } else {
                    return new LoginResDto("", "Failed");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public TokenValidationResponse validateToken(String token) {
        try {
            System.out.println("token");
            String userName = jwtUtil.extractUsername(token);
            System.out.println(userName);
            String role = jwtUtil.extractUserRole(token);
            boolean isValid = !jwtUtil.isTokenExpired(token);
            System.out.println("Token: " + token);
            return new TokenValidationResponse(isValid, userName, role);
        } catch (Exception e) {
            return new TokenValidationResponse(false, null, null);
        }
    }
}
