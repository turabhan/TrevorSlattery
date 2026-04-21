package ru.urfu.trevorslattery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.urfu.trevorslattery.entity.UserEntity;

import java.util.List;

public interface UserRepository
        extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findByDeletedFalse();
}
