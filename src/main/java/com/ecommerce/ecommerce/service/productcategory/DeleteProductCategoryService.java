package com.ecommerce.ecommerce.service.productcategory;

import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.dtos.common.request.DeleteDataRequestDto;
import com.ecommerce.ecommerce.dtos.common.response.DeleteDataResponseDto;
import com.ecommerce.ecommerce.entity.ProductCategory;
import com.ecommerce.ecommerce.repository.productcategory.ProductCategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteProductCategoryService {
    
    private final ProductCategoryRepository productCategoryRepository;

    public DeleteDataResponseDto delete(DeleteDataRequestDto dto) {
        ProductCategory productCategory = productCategoryRepository.findById(dto.getId())
            .orElseThrow(() -> new RuntimeException("Product category not found!"));
        productCategoryRepository.delete(productCategory);
        
        return new DeleteDataResponseDto("Product category deleted succesfully!");
    }
}
