package ru.urfu.trevorslattery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.urfu.trevorslattery.entity.UserEntity;

public interface UserRepository
        extends JpaRepository<UserEntity, Long> {
}
