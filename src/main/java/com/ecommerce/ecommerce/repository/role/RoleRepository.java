package com.ecommerce.ecommerce.repository.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecommerce.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    
}
