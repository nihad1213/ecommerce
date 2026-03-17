package com.ecommerce.ecommerce.service.role;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ecommerce.ecommerce.dtos.role.request.UpdateRoleRequestDto;
import com.ecommerce.ecommerce.dtos.role.response.UpdateRoleResponseDto;
import com.ecommerce.ecommerce.entity.Role;
import com.ecommerce.ecommerce.repository.role.RoleRepository;

@ExtendWith(MockitoExtension.class)
class UpdateRoleServiceTest {

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private UpdateRoleService service;

    @Test
    void shouldUpdateRole() {
        Role role = new Role();
        role.setId(1L);
        role.setName("OLD");

        when(roleRepository.findById(1L)).thenReturn(Optional.of(role));

        UpdateRoleRequestDto dto = new UpdateRoleRequestDto();
        dto.setId(1L);
        dto.setName("NEW");

        UpdateRoleResponseDto response = service.update(dto);

        assertEquals("Role updated successfully", response.getMessage());
        assertEquals("NEW", role.getName());
        verify(roleRepository).save(role);
    }

    @Test
    void shouldThrowIfRoleNotFound() {
        when(roleRepository.findById(1L)).thenReturn(Optional.empty());

        UpdateRoleRequestDto dto = new UpdateRoleRequestDto();
        dto.setId(1L);
        dto.setName("NEW");

        RuntimeException exception = assertThrows(RuntimeException.class, () -> service.update(dto));
        assertEquals("Role not found!", exception.getMessage());
    }
}