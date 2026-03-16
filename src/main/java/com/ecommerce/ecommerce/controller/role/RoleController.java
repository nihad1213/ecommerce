package com.ecommerce.ecommerce.controller.role;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.ecommerce.dtos.common.request.DeleteDataRequestDto;
import com.ecommerce.ecommerce.dtos.common.request.PaginationRequestDto;
import com.ecommerce.ecommerce.dtos.common.request.ReadOneDataRequestDto;
import com.ecommerce.ecommerce.dtos.common.response.DeleteDataResponseDto;
import com.ecommerce.ecommerce.dtos.role.request.CreateRoleRequestDto;
import com.ecommerce.ecommerce.dtos.role.request.ReadAllRolesRequestDto;
import com.ecommerce.ecommerce.dtos.role.request.UpdateRoleRequestDto;
import com.ecommerce.ecommerce.dtos.role.response.CreateRoleResponseDto;
import com.ecommerce.ecommerce.dtos.role.response.ReadAllRolesResponseDto;
import com.ecommerce.ecommerce.dtos.role.response.RoleDto;
import com.ecommerce.ecommerce.dtos.role.response.UpdateRoleResponseDto;
import com.ecommerce.ecommerce.service.role.CreateRoleService;
import com.ecommerce.ecommerce.service.role.DeleteRoleService;
import com.ecommerce.ecommerce.service.role.ReadAllRolesService;
import com.ecommerce.ecommerce.service.role.ReadOneRoleService;
import com.ecommerce.ecommerce.service.role.UpdateRoleService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/role")
@Validated
public class RoleController {

    private final CreateRoleService createRoleService;
    private final DeleteRoleService deleteRoleService;
    private final ReadAllRolesService readAllRolesService;
    private final ReadOneRoleService readOneRoleService;
    private final UpdateRoleService updateRoleService;

    @PostMapping("/create")
    public CreateRoleResponseDto create(@RequestBody @Valid CreateRoleRequestDto dto) {
        return createRoleService.createRole(dto);
    }

    @GetMapping("/read-all")
    public ReadAllRolesResponseDto readAll(ReadAllRolesRequestDto dto, PaginationRequestDto pagination) {
        return readAllRolesService.readAll(dto, pagination);
    }

    @GetMapping("/read-one")
    public RoleDto readOne(ReadOneDataRequestDto dto) {
        return readOneRoleService.readOne(dto);
    }

    @PutMapping("/update")
    public UpdateRoleResponseDto update(@RequestBody @Valid UpdateRoleRequestDto dto) {
        return updateRoleService.update(dto);
    }

    @DeleteMapping("/delete")
    public DeleteDataResponseDto delete(@RequestBody @Valid DeleteDataRequestDto dto) {
        return deleteRoleService.delete(dto);
    }
}