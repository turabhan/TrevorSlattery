package ru.urfu.trevorslattery.dto.mapping;

import org.mapstruct.Mapper;
import ru.urfu.trevorslattery.dto.OrderDto;
import ru.urfu.trevorslattery.entity.OrderEntity;

@Mapper(componentModel = "spring")
public interface OrderMapping {
    OrderDto toDto(OrderEntity  entity);
    OrderEntity toEntity(OrderDto dto);
}
