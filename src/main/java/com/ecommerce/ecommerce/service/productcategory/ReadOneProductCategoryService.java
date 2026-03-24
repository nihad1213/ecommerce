package com.ecommerce.ecommerce.service.productcategory;

import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.dtos.common.request.ReadOneDataRequestDto;
import com.ecommerce.ecommerce.dtos.productcategory.response.ProductCategoryDto;
import com.ecommerce.ecommerce.entity.ProductCategory;
import com.ecommerce.ecommerce.repository.productcategory.ProductCategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReadOneProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    public ProductCategoryDto readOne(ReadOneDataRequestDto dto) {
        ProductCategory category = productCategoryRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Product category not found!"));

        return new ProductCategoryDto(
                category.getId(),
                category.getName()
        );
    }
}