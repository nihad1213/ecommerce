package com.ecommerce.ecommerce.dtos.auth.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginRequestDto {
    @NotBlank(message="Email can't be empty!")
    String email;

    @NotBlank(message="Password can't be empty!")
    String password;
}
