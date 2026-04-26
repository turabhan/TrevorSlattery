package ru.urfu.trevorslattery.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.urfu.trevorslattery.enums.ProductCategory;

import java.math.BigDecimal;

@Data
@Getter
@Setter
public class ProductDto {
    Long id;
    String name;
    String description;
    BigDecimal price;
    Integer quantity;

    @Enumerated(EnumType.STRING)
    ProductCategory category;
}
