package com.ecommerce.ecommerce.service.role;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.dtos.role.request.CreateRoleRequestDto;
import com.ecommerce.ecommerce.dtos.role.response.CreateRoleResponseDto;
import com.ecommerce.ecommerce.entity.Permission;
import com.ecommerce.ecommerce.entity.Role;
import com.ecommerce.ecommerce.repository.permission.PermissionRepository;
import com.ecommerce.ecommerce.repository.role.RoleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateRoleService {
    
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    public CreateRoleResponseDto createRole(CreateRoleRequestDto dto) {
        
        if (roleRepository.existsByName(dto.getName()))
            throw new RuntimeException("Role with this name already exists");
        
        Role role = new Role();
        role.setName(dto.getName());

        if (dto.getPermissionKeys() != null && !dto.getPermissionKeys().isEmpty()) {
            Set<Permission> permissions = dto.getPermissionKeys().stream()
                .map(key -> permissionRepository.findByPermissionKey(key)
                    .orElseThrow(() -> new RuntimeException("Permission not found: " + key)))
                .collect(Collectors.toSet());

            role.setPermissions(permissions);
        }

        roleRepository.save(role);
        return new CreateRoleResponseDto("Role created successfully!");
    }
}
