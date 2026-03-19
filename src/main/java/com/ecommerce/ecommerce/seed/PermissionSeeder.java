package com.ecommerce.ecommerce.seed;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ecommerce.ecommerce.entity.Permission;
import com.ecommerce.ecommerce.repository.permission.PermissionRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PermissionSeeder implements CommandLineRunner{
    
    private final PermissionRepository permissionRepository;

    @Override
    public void run(String... args) {
        seedPermission();
    }

    private void seedPermission() {
        createPermission("create_user", "Create User");
        createPermission("update_user", "Update User");
    }

    private void createPermission(String key, String name) {
        if (!permissionRepository.existsByPermissionKey(key)) {
            Permission permission = new Permission();
            permission.setPermissionKey(key);
            permission.setPermissionName(name);

            permissionRepository.save(permission);
        }
    }

}
