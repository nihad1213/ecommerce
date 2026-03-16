package com.ecommerce.ecommerce.service.role;

import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.dtos.role.request.CreateRoleRequestDto;
import com.ecommerce.ecommerce.dtos.role.response.CreateRoleResponseDto;
import com.ecommerce.ecommerce.entity.Role;
import com.ecommerce.ecommerce.repository.role.RoleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateRoleService {
    
    private final RoleRepository roleRepository;

    public CreateRoleResponseDto createRole(CreateRoleRequestDto dto) {
        
        if (roleRepository.existsByName(dto.getName()))
            throw new RuntimeException("Role with this name already exists");
        
        Role role = new Role();
        role.setName(dto.getName());

        roleRepository.save(role);
        return new CreateRoleResponseDto("Role created successfully!");
    }
}
