package ru.urfu.trevorslattery.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @Enumerated(EnumType.STRING)
    OrderStatus status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    UserEntity user;
}
