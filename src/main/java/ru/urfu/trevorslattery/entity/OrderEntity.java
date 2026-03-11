package ru.urfu.trevorslattery.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.urfu.trevorslattery.enums.OrderStatus;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @ManyToOne
    private UserEntity user;

}
