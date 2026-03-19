package com.ecommerce.ecommerce.service.role;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.dtos.common.request.PaginationRequestDto;
import com.ecommerce.ecommerce.dtos.role.request.ReadAllRolesRequestDto;
import com.ecommerce.ecommerce.dtos.role.response.ReadAllRolesResponseDto;
import com.ecommerce.ecommerce.dtos.role.response.RoleDto;
import com.ecommerce.ecommerce.entity.Role;
import com.ecommerce.ecommerce.repository.role.RoleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReadAllRolesService {

    private final RoleRepository roleRepository;

    public ReadAllRolesResponseDto readAll(ReadAllRolesRequestDto dto, PaginationRequestDto pagination) {

        PageRequest pageRequest =
                PageRequest.of(pagination.getPageNumber() - 1, pagination.getPageSize());

        Page<Role> rolePage;

        String name = dto.getName();

        if (dto.getName() == null || dto.getName().isBlank()) {
            rolePage = roleRepository.findAll(pageRequest);
        } else {
            rolePage = roleRepository.findByNameContainingIgnoreCase(name.trim(), pageRequest);
        }
        

        List<RoleDto> roles =
                rolePage.getContent()
                        .stream()
                        .map(role -> new RoleDto(
                                role.getId(),
                                role.getName(),
                                role.getPermissions() == null ? Set.of() :
                                    role.getPermissions()
                                        .stream()
                                        .map(permission -> permission.getPermissionName())
                                        .collect(Collectors.toSet())
                        ))
                        .toList();

        return new ReadAllRolesResponseDto(roles);
    }
}