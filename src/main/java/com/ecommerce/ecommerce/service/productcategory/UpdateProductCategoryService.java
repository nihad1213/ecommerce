package com.ecommerce.ecommerce.service.productcategory;

import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.dtos.productcategory.request.UpdateProductCategoryRequestDto;
import com.ecommerce.ecommerce.dtos.productcategory.response.UpdateProductCategoryResponseDto;
import com.ecommerce.ecommerce.entity.ProductCategory;
import com.ecommerce.ecommerce.repository.productcategory.ProductCategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    public UpdateProductCategoryResponseDto update(UpdateProductCategoryRequestDto dto) {

        ProductCategory category = productCategoryRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Product category not found!"));

        if (!category.getName().equals(dto.getName()) &&
                productCategoryRepository.existsByName(dto.getName())) {
            throw new RuntimeException("Product category with this name already exists");
        }

        category.setName(dto.getName());
        productCategoryRepository.save(category);

        return new UpdateProductCategoryResponseDto("Product category updated successfully");
    }
}