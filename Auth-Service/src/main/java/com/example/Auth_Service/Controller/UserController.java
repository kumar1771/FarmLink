package com.example.Auth_Service.Controller;

import com.example.Auth_Service.Model.TokenValidationResponse;
import com.example.Auth_Service.Service.UserService;
import com.example.Auth_Service.dto.LoginReqDto;
import com.example.Auth_Service.dto.LoginResDto;
import com.example.Auth_Service.dto.SignUpDto;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Users")
public class UserController {
    @Autowired
    private UserService userService;

    @Value("${apikey}")
    private String api_key;

    @PostMapping("signup")
    public ResponseEntity<String> SignUp(@RequestBody SignUpDto signUp){
        return ResponseEntity.ok(userService.SignUp(signUp));
    }
    @PostMapping("login")
    public ResponseEntity<LoginResDto> Login(@RequestBody LoginReqDto login){
        return ResponseEntity.ok().body(userService.Login(login));
    }
    @GetMapping("/validate")
    public ResponseEntity<TokenValidationResponse> validateToken(
            @RequestHeader("Authorization") String token,
            @RequestHeader("X-Api-key") String apikey) {

        System.out.println("Received Authorization header: " + token);
        System.out.println("Received X-Api-key header: " + apikey);

        if(!apikey.equals(api_key)) {
            System.out.println("API key mismatch");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        if(token == null || !token.startsWith("Bearer ")) {
            System.out.println("Token missing or invalid format");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        TokenValidationResponse validateToken = userService.validateToken(token);
        System.out.println("Validation result: " + validateToken);

        return ResponseEntity.ok(validateToken);
    }


}
