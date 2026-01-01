package com.example.UserSecurity.PasswordEncoder;

import org.springframework.context.annotation.Bean;

public class PasswordEncoder {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
    }
}
