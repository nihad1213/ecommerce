package com.ecommerce.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="permissions")
@Getter
@Setter
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Permission extends BaseEntity {
    @Column(name = "permission_key", nullable = false, unique = true)
    String permissionKey;

    @Column(name = "permission_name", nullable = false)
    String permissionName;
}
