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
        createPermission("create_role", "Create Role");
        createPermission("update_role", "Update Role");
        createPermission("read_role", "Read Role");
        createPermission("delete_role", "Delete Role");

        createPermission("create_product_category", "Create Product Category");
        createPermission("update_product_category", "Update Product Category");
        createPermission("read_product_category", "Read Product Category");
        createPermission("delete_product_category", "Delete Product Category");~

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
