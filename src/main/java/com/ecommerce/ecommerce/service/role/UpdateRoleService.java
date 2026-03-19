package com.ecommerce.ecommerce.service.role;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.dtos.role.request.UpdateRoleRequestDto;
import com.ecommerce.ecommerce.dtos.role.response.UpdateRoleResponseDto;
import com.ecommerce.ecommerce.entity.Permission;
import com.ecommerce.ecommerce.entity.Role;
import com.ecommerce.ecommerce.repository.permission.PermissionRepository;
import com.ecommerce.ecommerce.repository.role.RoleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateRoleService {

    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    public UpdateRoleResponseDto update(UpdateRoleRequestDto dto) {

        Role role = roleRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Role not found!"));

        role.setName(dto.getName());

        if (dto.getPermissionKeys() != null) {
            Set<Permission> permissions = dto.getPermissionKeys().stream()
                .map(key -> permissionRepository.findByPermissionKey(key)
                .orElseThrow(() -> new RuntimeException("Permission not found: " + key)))
                .collect(Collectors.toSet());

            role.setPermissions(permissions);
        }


        roleRepository.save(role);

        return new UpdateRoleResponseDto("Role updated successfully");
    }
}