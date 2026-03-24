package com.ecommerce.ecommerce.service.productcategory;

import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.dtos.productcategory.request.CreateProductCategoryRequestDto;
import com.ecommerce.ecommerce.dtos.productcategory.response.CreateProductCategoryResponseDto;
import com.ecommerce.ecommerce.entity.ProductCategory;
import com.ecommerce.ecommerce.repository.productcategory.ProductCategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateProductCategoryService {
    
    private final ProductCategoryRepository productCategoryRepository;

    public CreateProductCategoryResponseDto create(CreateProductCategoryRequestDto dto) {
        if (productCategoryRepository.existsByName(dto.getName()))
            throw new RuntimeException("Product Category with this name already exists!");
        
        ProductCategory productCategory = new ProductCategory();
        productCategory.setName(dto.getName());
        productCategoryRepository.save(productCategory);

        return new CreateProductCategoryResponseDto("Product category created successfully!");
    }
}
