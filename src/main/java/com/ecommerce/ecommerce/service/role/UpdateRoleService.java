package com.ecommerce.ecommerce.service.role;

import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.dtos.role.request.UpdateRoleRequestDto;
import com.ecommerce.ecommerce.dtos.role.response.UpdateRoleResponseDto;
import com.ecommerce.ecommerce.entity.Role;
import com.ecommerce.ecommerce.repository.role.RoleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateRoleService {

    private final RoleRepository roleRepository;

    public UpdateRoleResponseDto update(UpdateRoleRequestDto dto) {

        Role role = roleRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Role not found!"));

        role.setName(dto.getName());

        roleRepository.save(role);

        return new UpdateRoleResponseDto("Role updated successfully");
    }
}