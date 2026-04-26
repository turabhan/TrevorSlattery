package ru.urfu.trevorslattery.dto.mapping;

import org.mapstruct.Mapper;
import ru.urfu.trevorslattery.dto.CartDto;
import ru.urfu.trevorslattery.entity.CartItemEntity;

@Mapper(componentModel = "spring")
public interface CartMapping {
    CartDto toDto(CartItemEntity entity);
    CartItemEntity toEntity(CartDto dto);
}
