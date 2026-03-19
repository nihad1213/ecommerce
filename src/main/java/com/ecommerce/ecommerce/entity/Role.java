package com.ecommerce.ecommerce.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "roles")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role extends BaseEntity {

    @Column(nullable = false, unique = true)
    String name;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
        name="role_permissions",
        joinColumns=@JoinColumn(name="role_id"),
        inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    Set<Permission> permissions;
}