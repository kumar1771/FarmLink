package com.example.Auth_Service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain Filter(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/h2-console/**").permitAll()
//                        .requestMatchers("/Users/signup").permitAll()
                        .anyRequest().permitAll())
                .csrf(csrf->csrf.disable())
                .headers(headers -> headers.frameOptions(frame -> frame.disable()));;

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordencoder() {
        return new BCryptPasswordEncoder(14);
    }
}
