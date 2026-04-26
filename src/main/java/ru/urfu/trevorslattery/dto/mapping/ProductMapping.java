package ru.urfu.trevorslattery.dto.mapping;

import org.mapstruct.Mapper;
import ru.urfu.trevorslattery.dto.ProductDto;
import ru.urfu.trevorslattery.entity.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductMapping {
    ProductDto toDto(ProductEntity entity);
    ProductEntity toEntity(ProductDto dto);
}
