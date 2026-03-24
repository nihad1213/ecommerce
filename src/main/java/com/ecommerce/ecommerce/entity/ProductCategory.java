package com.ecommerce.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "product_categories")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductCategory extends BaseEntity{
    @Column(nullable = false, unique = true)
    String name;
}
