package com.example.UserSecurity.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class ProductRequest {
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Price is required")
    @Min(value = 1, message = "Price must be greater than 0")
    private Integer price;

    @NotBlank(message = "Description cannot be empty")
    private String description;
}
