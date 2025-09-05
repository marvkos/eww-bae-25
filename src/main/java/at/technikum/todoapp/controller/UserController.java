package at.technikum.todoapp.controller;

import at.technikum.todoapp.dto.Registration;
import at.technikum.todoapp.entity.MyUser;
import at.technikum.todoapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public MyUser create(@RequestBody @Valid Registration registration) {
        return userService.register(registration);
    }
}
