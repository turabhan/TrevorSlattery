package ru.urfu.trevorslattery.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.urfu.trevorslattery.entity.UserEntity;
import ru.urfu.trevorslattery.enums.Role;
import ru.urfu.trevorslattery.service.UserService;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserEntity saveUser(@RequestBody UserEntity user){
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.removeUser(id);
    }
}
