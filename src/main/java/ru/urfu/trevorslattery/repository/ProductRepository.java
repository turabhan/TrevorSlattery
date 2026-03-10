package ru.urfu.trevorslattery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.urfu.trevorslattery.entity.ProductEntity;

public interface ProductRepository
        extends JpaRepository<ProductEntity, Long> {
}
