package com.example.UserSecurity.Controller;

import com.example.UserSecurity.Requests.LoginRequest;
import com.example.UserSecurity.Service.AuthService;
import com.example.UserSecurity.dto.LoginRequestDto;
import com.example.UserSecurity.dto.LoginResponseDto;
import com.example.UserSecurity.dto.SignupResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final AuthService authService;

    public AuthController(AuthenticationManager authManager, AuthService authService) {
        this.authManager = authManager;
        this.authService = authService;
    }

   @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
       System.out.println("LOGIN CONTROLLER HIT");
        return ResponseEntity.ok(authService.login(loginRequestDto));
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupResponseDto> signup(@RequestBody LoginRequestDto signupRequestDto) {
        return ResponseEntity.ok(authService.signup(signupRequestDto));
    }
}
