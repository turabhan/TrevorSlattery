package ru.urfu.trevorslattery.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.urfu.trevorslattery.dto.UserDto;
import ru.urfu.trevorslattery.dto.mapping.UserMapping;
import ru.urfu.trevorslattery.entity.UserEntity;
import ru.urfu.trevorslattery.enums.Role;
import ru.urfu.trevorslattery.repository.UserRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final TransactionLogService transactionLogService;
    private final UserMapping userMapping;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserDto saveUser(UserDto dto){
        UserEntity user = userMapping.toEntity(dto);
        if (user.getId() == null && user.getRole() == null) {
            user.setRole(Role.USER);
        }
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setCreatedAt(LocalDateTime.now());
        UserEntity savedUser = userRepository.save(user);

        return userMapping.toDto(savedUser);
    }
    public void  removeUser(Long id){
        UserEntity user = userRepository.findById(id).orElseThrow();

        user.setDeleted(true);
        user.setEmail("deleted_" + System.currentTimeMillis() + "_" + user.getEmail());
        user.setPassword(null);
        userRepository.save(user);

        transactionLogService.log("DELETE USER", id,
                "User anonymized and soft deleted");
    }
}
