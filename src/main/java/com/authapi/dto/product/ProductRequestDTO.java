package com.authapi.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequestDTO {

    @NotBlank(message = "Name is mandatory!")
    private String name;

    private String description;

    @NotNull(message = "Price is mandatory!")
    private BigDecimal price;
}
