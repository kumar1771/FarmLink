package com.example.Auth_Service.Model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TokenValidationResponse {
    private boolean valid;
    private String username;
    private String role;
}
