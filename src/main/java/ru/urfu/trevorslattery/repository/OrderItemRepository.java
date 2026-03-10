package ru.urfu.trevorslattery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.urfu.trevorslattery.entity.OrderItemEntity;

public interface OrderItemRepository
        extends JpaRepository<OrderItemEntity, Long> {
}
