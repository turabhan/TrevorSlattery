package ru.urfu.trevorslattery.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.urfu.trevorslattery.entity.UserEntity;
import ru.urfu.trevorslattery.enums.Role;
import ru.urfu.trevorslattery.repository.UserRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final TransactionLogService transactionLogService;

    @Transactional
    public UserEntity saveUser(UserEntity user){

        UserEntity userToCreate = new UserEntity();
        userToCreate.setEmail(user.getEmail());
        userToCreate.setPassword(user.getPassword());
        userToCreate.setRole(Role.USER);
        userToCreate.setCreatedAt(LocalDateTime.now());

        return userRepository.save(userToCreate);
    }
    public void  removeUser(Long id){
        UserEntity user = userRepository.findById(id).orElseThrow();

        user.setDeleted(true);
        user.setEmail(null);
        user.setPassword(null);
        userRepository.save(user);

        transactionLogService.log("DELETE USER", id,
                "User anonymized and soft deleted");
    }
}
