package com.authapi.dto.product;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponseDTO {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
}
