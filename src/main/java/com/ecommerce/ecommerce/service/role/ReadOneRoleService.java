package com.ecommerce.ecommerce.service.role;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.dtos.common.request.ReadOneDataRequestDto;
import com.ecommerce.ecommerce.dtos.role.response.RoleDto;
import com.ecommerce.ecommerce.entity.Role;
import com.ecommerce.ecommerce.repository.role.RoleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReadOneRoleService {
    
    private final RoleRepository roleRepository;

    public RoleDto readOne(ReadOneDataRequestDto dto) {
        Role role = roleRepository.findById(dto.getId())
            .orElseThrow(() -> new RuntimeException("Role not found!"));
        
        return new RoleDto(
            role.getId(),
            role.getName(),
            role.getPermissions() == null ? Set.of() :
            role.getPermissions()
                .stream()
                .map(p -> p.getPermissionName())
                .collect(Collectors.toSet())
        );
    }
}
