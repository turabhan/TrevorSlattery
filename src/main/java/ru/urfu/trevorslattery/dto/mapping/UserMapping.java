package ru.urfu.trevorslattery.dto.mapping;

import org.mapstruct.Mapper;
import ru.urfu.trevorslattery.dto.UserDto;
import ru.urfu.trevorslattery.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapping {

    UserDto toDto(UserEntity entity);

    UserEntity toEntity(UserDto dto);

//    UserDto userDto(UserEntity userEntity);
//    UserDto dto = new UserDto();
//    dto.setId(userEntity.getId());
//    dto.setEmail(userEntity.getEmail());
//    dto.setPassword(userEntity.getPassword());
//    dto.setRole(userEntity.getRole());
//    dto.setCreatedAt(userEntity.getLocalDateTime.now());
//    return dto;
}
// public UserEntity userEntity(UserDto userDto){
//    UserEntity userEntity = new UserEntity();
//    userEntity.setEmail(userDto.getEmail());
//    userEntity.setPassword(userDto.getPassword());
//    return userEntity;
// }