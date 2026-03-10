package ru.urfu.trevorslattery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.urfu.trevorslattery.entity.CartItemEntity;

public interface CartItemRepository
        extends JpaRepository<CartItemEntity,Long> {
}
