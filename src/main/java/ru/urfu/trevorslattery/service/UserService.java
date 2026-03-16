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
        userRepository.deleteById(id);
    }
}
