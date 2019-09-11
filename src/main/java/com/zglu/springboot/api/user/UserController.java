package com.zglu.springboot.api.user;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/user/{id}")
    public User get(@PathVariable int id) {
        return service.get(id);
    }

    @PostMapping("/user")
    public User get(User user) {
        return service.add(user);
    }
}
