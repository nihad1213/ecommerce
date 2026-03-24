package com.ecommerce.ecommerce.dtos.productcategory.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateProductCategoryRequestDto {
    @NotNull(message = "Id can't be null!")
    Long id;

    @NotBlank(message = "Name can't be null!")
    String name;
}
