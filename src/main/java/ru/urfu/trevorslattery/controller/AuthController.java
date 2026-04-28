package ru.urfu.trevorslattery.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.urfu.trevorslattery.dto.UserDto;
import ru.urfu.trevorslattery.service.UserService;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login";// templates/login.html
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("userDto", new UserDto());
        return "register";// templates/register.html
    }
    @PostMapping("/register")
    public String registerSubmit(@Valid @ModelAttribute("UserDto") UserDto userDto,
                                 BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        userService.saveUser(userDto);
        return "redirect:/login";
    }
}
