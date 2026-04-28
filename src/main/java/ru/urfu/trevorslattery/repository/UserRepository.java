package ru.urfu.trevorslattery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.urfu.trevorslattery.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepository
        extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findByDeletedFalse();
    Optional<UserEntity> findByEmail(String email);
}
