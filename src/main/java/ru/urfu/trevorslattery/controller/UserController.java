package ru.urfu.trevorslattery.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.urfu.trevorslattery.dto.UserDto;
import ru.urfu.trevorslattery.service.UserService;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserDto saveUser(@Valid@RequestBody UserDto userDto){
        return userService.saveUser(userDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.removeUser(id);
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute UserDto dto,
                           BindingResult result) {

        if (result.hasErrors()) {
            return "register";
        }

        userService.saveUser(dto);
        return "redirect:/login";
    }
}
