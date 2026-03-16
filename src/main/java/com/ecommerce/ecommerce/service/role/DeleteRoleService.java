package com.ecommerce.ecommerce.service.role;

import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.dtos.common.request.DeleteDataRequestDto;
import com.ecommerce.ecommerce.dtos.common.response.DeleteDataResponseDto;
import com.ecommerce.ecommerce.entity.Role;
import com.ecommerce.ecommerce.repository.role.RoleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteRoleService {
    
    private final RoleRepository roleRepository;

    public DeleteDataResponseDto delete(DeleteDataRequestDto dto) {
        Role role = roleRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        roleRepository.delete(role);

        return new DeleteDataResponseDto("Role deleted successfully!");
    }
}
