package com.ecommerce.ecommerce.repository.permission;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecommerce.entity.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long>{
    Optional<Permission> findByPermissionKey(String permissionKey);

    boolean existsByPermissionKey(String permissionKey);
}
