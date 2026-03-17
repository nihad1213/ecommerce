package com.ecommerce.ecommerce.service.role;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ecommerce.ecommerce.dtos.common.request.DeleteDataRequestDto;
import com.ecommerce.ecommerce.dtos.common.response.DeleteDataResponseDto;
import com.ecommerce.ecommerce.entity.Role;
import com.ecommerce.ecommerce.repository.role.RoleRepository;

@ExtendWith(MockitoExtension.class)
class DeleteRoleServiceTest {

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private DeleteRoleService deleteRoleService;

    @Test
    void shouldDeleteRoleSuccessfully() {
        Role role = new Role();
        role.setId(1L);

        when(roleRepository.findById(1L)).thenReturn(Optional.of(role));

        DeleteDataRequestDto dto = new DeleteDataRequestDto();
        dto.setId(1L);

        DeleteDataResponseDto response = deleteRoleService.delete(dto);

        assertEquals("Role deleted successfully!", response.getMessage());
        verify(roleRepository).delete(role);
    }

    @Test
    void shouldThrowIfRoleNotFound() {
        when(roleRepository.findById(1L)).thenReturn(Optional.empty());

        DeleteDataRequestDto dto = new DeleteDataRequestDto();
        dto.setId(1L);

        Throwable exception = assertThrows(RuntimeException.class, () -> deleteRoleService.delete(dto));
        assertNotNull(exception);
    }
}