package com.ecommerce.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="users")
@Getter
@Setter
@FieldDefaults(level=AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity{
    @Column(nullable=false)
    String firstName;

    @Column(nullable=false)
    String lastName;

    @Column(nullable=false, unique=true)
    String email;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @Column(nullable=false)
    String password;
}
