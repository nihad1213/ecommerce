package com.ecommerce.ecommerce.service.role;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.ecommerce.ecommerce.dtos.common.request.PaginationRequestDto;
import com.ecommerce.ecommerce.dtos.role.request.ReadAllRolesRequestDto;
import com.ecommerce.ecommerce.dtos.role.response.ReadAllRolesResponseDto;
import com.ecommerce.ecommerce.entity.Role;
import com.ecommerce.ecommerce.repository.role.RoleRepository;

@ExtendWith(MockitoExtension.class)
class ReadAllRolesServiceTest {

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private ReadAllRolesService service;

    @Test
    void shouldReturnAllRolesWhenNameIsNull() {
        Role role = new Role();
        role.setId(1L);
        role.setName("ADMIN");

        Page<Role> page = new PageImpl<>(List.of(role));

        when(roleRepository.findAll(any(PageRequest.class))).thenReturn(page);

        ReadAllRolesRequestDto dto = new ReadAllRolesRequestDto();
        PaginationRequestDto pagination = new PaginationRequestDto(1, 10);

        ReadAllRolesResponseDto response = service.readAll(dto, pagination);

        assertEquals(1, response.getRoles().size());
        assertEquals("ADMIN", response.getRoles().get(0).getName());
    }

    @Test
    void shouldFilterByName() {
        Role role = new Role();
        role.setId(1L);
        role.setName("ADMIN");

        Page<Role> page = new PageImpl<>(List.of(role));

        when(roleRepository.findByNameContainingIgnoreCase(eq("AD"), any(PageRequest.class)))
                .thenReturn(page);

        ReadAllRolesRequestDto dto = new ReadAllRolesRequestDto();
        dto.setName("AD");
        PaginationRequestDto pagination = new PaginationRequestDto(1, 10);

        ReadAllRolesResponseDto response = service.readAll(dto, pagination);

        assertEquals(1, response.getRoles().size());
        assertEquals("ADMIN", response.getRoles().get(0).getName());
    }
}