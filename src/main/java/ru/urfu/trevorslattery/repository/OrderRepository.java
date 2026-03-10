package ru.urfu.trevorslattery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.urfu.trevorslattery.entity.OrderEntity;

public interface OrderRepository
        extends JpaRepository<OrderEntity, Long> {
}
