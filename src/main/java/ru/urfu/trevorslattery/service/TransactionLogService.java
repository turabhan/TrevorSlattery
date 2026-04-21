package ru.urfu.trevorslattery.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.urfu.trevorslattery.entity.TransactionLogEntity;
import ru.urfu.trevorslattery.repository.TransactionLogRepository;
@Service
@RequiredArgsConstructor
public class TransactionLogService{
    private final TransactionLogRepository transactionLogRepository;

    public void log(String action, Long userId, String details){
        TransactionLogEntity log = new TransactionLogEntity();
        log.setAction(action);
        log.setUserId(userId);
        log.setDetails(details);

        transactionLogRepository.save(log);
    }
}
