package com.zglu.springboot.api.mongo;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserMongoController {

    private final UserMongoService service;

    @GetMapping("/user-mongo/{id}")
    public UserMongo get(@PathVariable String id) {
        return service.get(id);
    }

    @PostMapping("/user-mongo")
    public UserMongo get(@RequestBody UserMongo user) {
        return service.add(user);
    }
}
