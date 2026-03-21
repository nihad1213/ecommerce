package com.ecommerce.ecommerce.service.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.dtos.auth.request.RegisterRequestDto;
import com.ecommerce.ecommerce.dtos.auth.response.RegisterResponseDto;
import com.ecommerce.ecommerce.entity.Role;
import com.ecommerce.ecommerce.entity.User;
import com.ecommerce.ecommerce.repository.role.RoleRepository;
import com.ecommerce.ecommerce.repository.user.UserRepository;
import com.ecommerce.ecommerce.security.JwtTokenProvider;

import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RegisterService {

    UserRepository userRepository;
    RoleRepository roleRepository;
    PasswordEncoder passwordEncoder;
    JwtTokenProvider jwtTokenProvider;

    public RegisterResponseDto register(RegisterRequestDto request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email is already in use: " + request.getEmail());
        }

        Long roleId = request.getRoleId() != null ? request.getRoleId() : 1L;
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with id: " + roleId));

        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(role)
                .build();

        userRepository.save(user);

        String token = jwtTokenProvider.generateToken(user.getEmail());

        return new RegisterResponseDto(token);
    }
}