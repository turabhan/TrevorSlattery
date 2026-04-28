package ru.urfu.trevorslattery.dto.mapping;

import org.mapstruct.Mapper;
import ru.urfu.trevorslattery.dto.UserDto;
import ru.urfu.trevorslattery.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapping {
    UserDto toDto(UserEntity entity);
    UserEntity toEntity(UserDto dto);
}