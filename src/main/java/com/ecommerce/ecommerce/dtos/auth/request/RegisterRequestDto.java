package com.ecommerce.ecommerce.dtos.auth.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterRequestDto {
    @NotBlank(message = "First name can't be empty!")
    String firstName;

    @NotBlank(message = "Last name can't be empty!")
    String lastName;

    @Email(message = "Email should be valid!")
    @NotBlank(message = "Email can't be empty!")
    String email;

    @NotBlank(message = "Password can't be empty!")
    @Size(min = 6, message = "Password must be at least 6 characters")
    String password;

    Long roleId;
}
