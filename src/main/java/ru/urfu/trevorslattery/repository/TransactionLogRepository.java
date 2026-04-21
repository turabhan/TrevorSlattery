package ru.urfu.trevorslattery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.urfu.trevorslattery.entity.TransactionLogEntity;

public interface TransactionLogRepository
        extends JpaRepository<TransactionLogEntity, Long> {
}
