package com.authapi.entities.product;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Table(name = "product")
@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
}
