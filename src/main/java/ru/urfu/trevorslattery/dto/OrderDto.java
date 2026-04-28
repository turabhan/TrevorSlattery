package ru.urfu.trevorslattery.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.urfu.trevorslattery.entity.UserEntity;
import ru.urfu.trevorslattery.enums.OrderStatus;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class OrderDto {
    Long id;
    LocalDateTime createdAt;
    OrderStatus status;
    UserEntity user;
}
