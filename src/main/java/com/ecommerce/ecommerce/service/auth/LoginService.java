package com.ecommerce.ecommerce.service.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.dtos.auth.request.LoginRequestDto;
import com.ecommerce.ecommerce.dtos.auth.response.LoginResponseDto;
import com.ecommerce.ecommerce.security.JwtTokenProvider;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LoginService {

    AuthenticationManager authenticationManager;
    JwtTokenProvider jwtTokenProvider;

    public LoginResponseDto login(LoginRequestDto request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );

            String email = authentication.getName();
            String token = jwtTokenProvider.generateToken(email);

            return new LoginResponseDto(token);

        } catch (BadCredentialsException ex) {
            throw new BadCredentialsException("Invalid email or password");
        }
    }
}