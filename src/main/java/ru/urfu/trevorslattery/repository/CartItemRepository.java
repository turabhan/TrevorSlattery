package ru.urfu.trevorslattery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.urfu.trevorslattery.entity.CartItemEntity;
import ru.urfu.trevorslattery.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository
        extends JpaRepository<CartItemEntity,Long> {
    List<CartItemEntity> findByUser(UserEntity user);
}
