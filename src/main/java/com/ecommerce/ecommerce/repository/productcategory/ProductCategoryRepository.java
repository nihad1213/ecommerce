package com.ecommerce.ecommerce.repository.productcategory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecommerce.entity.ProductCategory;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long>{
    boolean existsByName(String name);

    Page<ProductCategory> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
