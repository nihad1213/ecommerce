package com.ecommerce.ecommerce.service.role;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ecommerce.ecommerce.dtos.common.request.ReadOneDataRequestDto;
import com.ecommerce.ecommerce.dtos.role.response.RoleDto;
import com.ecommerce.ecommerce.entity.Role;
import com.ecommerce.ecommerce.repository.role.RoleRepository;

@ExtendWith(MockitoExtension.class)
class ReadOneRoleServiceTest {

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private ReadOneRoleService service;

    @Test
    void shouldReturnRole() {
        Role role = new Role();
        role.setId(1L);
        role.setName("ADMIN");

        when(roleRepository.findById(1L)).thenReturn(Optional.of(role));

        ReadOneDataRequestDto dto = new ReadOneDataRequestDto();
        dto.setId(1L);

        RoleDto result = service.readOne(dto);

        assertEquals("ADMIN", result.getName());
    }

    @Test
    void shouldThrowIfNotFound() {
        when(roleRepository.findById(1L)).thenReturn(Optional.empty());

        ReadOneDataRequestDto dto = new ReadOneDataRequestDto();
        dto.setId(1L);

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> service.readOne(dto));
        assertEquals("Role not found!", thrown.getMessage());
    }
}