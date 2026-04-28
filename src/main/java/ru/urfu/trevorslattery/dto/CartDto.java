package ru.urfu.trevorslattery.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartDto {
    private Long id;
    private Integer quantity;

    private String productName;
    private Long productId;
    private BigDecimal price;

    private UserDto user;
    private ProductDto product;
}
