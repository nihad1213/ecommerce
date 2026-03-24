package com.ecommerce.ecommerce.controller.productcategory;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.dtos.common.request.DeleteDataRequestDto;
import com.ecommerce.ecommerce.dtos.common.request.PaginationRequestDto;
import com.ecommerce.ecommerce.dtos.common.request.ReadOneDataRequestDto;
import com.ecommerce.ecommerce.dtos.common.response.DeleteDataResponseDto;
import com.ecommerce.ecommerce.dtos.productcategory.request.CreateProductCategoryRequestDto;
import com.ecommerce.ecommerce.dtos.productcategory.request.ReadAllProductCategoryRequestDto;
import com.ecommerce.ecommerce.dtos.productcategory.request.UpdateProductCategoryRequestDto;
import com.ecommerce.ecommerce.dtos.productcategory.response.CreateProductCategoryResponseDto;
import com.ecommerce.ecommerce.dtos.productcategory.response.ProductCategoryDto;
import com.ecommerce.ecommerce.dtos.productcategory.response.ReadAllProductCategoriesResponseDto;
import com.ecommerce.ecommerce.dtos.productcategory.response.UpdateProductCategoryResponseDto;
import com.ecommerce.ecommerce.service.productcategory.CreateProductCategoryService;
import com.ecommerce.ecommerce.service.productcategory.DeleteProductCategoryService;
import com.ecommerce.ecommerce.service.productcategory.ReadAllProductCategoryService;
import com.ecommerce.ecommerce.service.productcategory.ReadOneProductCategoryService;
import com.ecommerce.ecommerce.service.productcategory.UpdateProductCategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/product-category")
@Validated
public class ProductCategoryController {
    
    private final CreateProductCategoryService createProductCategoryService;
    private final ReadAllProductCategoryService readAllProductCategoryService;
    private final ReadOneProductCategoryService readOneProductCategoryService;
    private final UpdateProductCategoryService updateProductCategoryService;
    private final DeleteProductCategoryService deleteProductCategoryService;

    @PostMapping("/create")
    public CreateProductCategoryResponseDto create(@RequestBody @Valid CreateProductCategoryRequestDto dto) {
        return createProductCategoryService.create(dto);
    }

    @PostMapping("/read-all")
    public ReadAllProductCategoriesResponseDto readAll(
            @RequestBody ReadAllProductCategoryRequestDto dto,
            @RequestParam int pageNumber,
            @RequestParam int pageSize
    ) {
        PaginationRequestDto pagination = new PaginationRequestDto(pageNumber, pageSize);
        return readAllProductCategoryService.readAll(dto, pagination);
    }

    @PostMapping("/read-one")
    public ProductCategoryDto readOne(@RequestBody @Valid ReadOneDataRequestDto dto) {
        return readOneProductCategoryService.readOne(dto);
    }

    @PutMapping("/update")
    public UpdateProductCategoryResponseDto update(@RequestBody @Valid UpdateProductCategoryRequestDto dto) {
        return updateProductCategoryService.update(dto);
    }

    @DeleteMapping("/delete")
    public DeleteDataResponseDto delete(@RequestBody @Valid DeleteDataRequestDto dto) {
        return deleteProductCategoryService.delete(dto);
    }
}
