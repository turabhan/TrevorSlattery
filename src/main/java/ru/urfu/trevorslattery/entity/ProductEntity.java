package ru.urfu.trevorslattery.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.urfu.trevorslattery.enums.ProductCategory;

import java.math.BigDecimal;


@Setter
@Getter
@Entity


public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    private ProductCategory category;

}