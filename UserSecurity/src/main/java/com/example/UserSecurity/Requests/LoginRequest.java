package com.example.UserSecurity.Requests;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {

    @NotBlank(message = "Username is mandatory")
    public String username;
    @NotBlank(message = "Password is mandatory")
    public String password;
}
