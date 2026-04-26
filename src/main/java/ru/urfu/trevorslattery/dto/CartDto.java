package ru.urfu.trevorslattery.dto;

import jakarta.persistence.*;
import ru.urfu.trevorslattery.entity.ProductEntity;
import ru.urfu.trevorslattery.entity.UserEntity;

public class CartDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Integer quantity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    UserEntity user;
    @ManyToOne
    @JoinColumn(name = "product_id")
    ProductEntity product;
}
