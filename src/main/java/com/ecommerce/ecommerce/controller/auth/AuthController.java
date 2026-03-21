package com.ecommerce.ecommerce.controller.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.dtos.auth.request.LoginRequestDto;
import com.ecommerce.ecommerce.dtos.auth.request.RegisterRequestDto;
import com.ecommerce.ecommerce.dtos.auth.response.LoginResponseDto;
import com.ecommerce.ecommerce.dtos.auth.response.RegisterResponseDto;
import com.ecommerce.ecommerce.service.auth.LoginService;
import com.ecommerce.ecommerce.service.auth.RegisterService;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthController {

    LoginService loginService;
    RegisterService registerService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginRequestDto request) {
        LoginResponseDto response = loginService.login(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDto> register(@Valid @RequestBody RegisterRequestDto request) {
        RegisterResponseDto response = registerService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}