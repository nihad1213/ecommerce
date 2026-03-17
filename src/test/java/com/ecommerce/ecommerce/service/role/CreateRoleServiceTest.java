package com.ecommerce.ecommerce.service.role;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ecommerce.ecommerce.dtos.role.request.CreateRoleRequestDto;
import com.ecommerce.ecommerce.dtos.role.response.CreateRoleResponseDto;
import com.ecommerce.ecommerce.entity.Role;
import com.ecommerce.ecommerce.repository.role.RoleRepository;

@ExtendWith(MockitoExtension.class)
class CreateRoleServiceTest {

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private CreateRoleService createRoleService;

    @Test
    void shouldCreateRoleSuccessfully() {
        CreateRoleRequestDto dto = new CreateRoleRequestDto();
        dto.setName("ADMIN");

        when(roleRepository.existsByName("ADMIN")).thenReturn(false);

        CreateRoleResponseDto response = createRoleService.createRole(dto);

        assertEquals("Role created successfully!", response.getMessage());
        verify(roleRepository).save(any(Role.class));
    }

    @Test
    void shouldThrowExceptionIfRoleExists() {
        CreateRoleRequestDto dto = new CreateRoleRequestDto();
        dto.setName("ADMIN");

        when(roleRepository.existsByName("ADMIN")).thenReturn(true);

        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> createRoleService.createRole(dto));

        assertEquals("Role with this name already exists", ex.getMessage());
    }
}