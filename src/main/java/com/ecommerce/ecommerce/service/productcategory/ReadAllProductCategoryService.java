package com.ecommerce.ecommerce.service.productcategory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.dtos.common.request.PaginationRequestDto;
import com.ecommerce.ecommerce.dtos.productcategory.request.ReadAllProductCategoryRequestDto;
import com.ecommerce.ecommerce.dtos.productcategory.response.ProductCategoryDto;
import com.ecommerce.ecommerce.dtos.productcategory.response.ReadAllProductCategoriesResponseDto;
import com.ecommerce.ecommerce.entity.ProductCategory;
import com.ecommerce.ecommerce.repository.productcategory.ProductCategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReadAllProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    public ReadAllProductCategoriesResponseDto readAll(ReadAllProductCategoryRequestDto dto, PaginationRequestDto pagination) {

        PageRequest pageRequest = PageRequest.of(pagination.getPageNumber() - 1, pagination.getPageSize());

        Page<ProductCategory> categoryPage;

        String name = dto.getName();

        if (name == null || name.isBlank()) {
            categoryPage = productCategoryRepository.findAll(pageRequest);
        } else {
            categoryPage = productCategoryRepository.findByNameContainingIgnoreCase(name.trim(), pageRequest);
        }

        List<ProductCategoryDto> categories = categoryPage.getContent()
                .stream()
                .map(category -> new ProductCategoryDto(
                    category.getId(),
                    category.getName()
                ))
                .toList();

        return new ReadAllProductCategoriesResponseDto(categories);
    }
}