package com.ecommerce.ecommerce.service.productcategory;

import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.dtos.productcategory.request.ReadAllProductCategoryRequestDto;
import com.ecommerce.ecommerce.dtos.productcategory.response.ReadAllProductCategoriesResponseDto;
import com.ecommerce.ecommerce.repository.productcategory.ProductCategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReadAllProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    public ReadAllProductCategoriesResponseDto readAll(ReadAllProductCategoryRequestDto dto) {
        
    }
}
