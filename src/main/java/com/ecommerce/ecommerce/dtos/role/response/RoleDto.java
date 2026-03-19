package com.ecommerce.ecommerce.dtos.role.response;

import java.util.Set;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleDto {
    Long id;
    String name;
    Set<String> permissions;
}