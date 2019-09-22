package com.zglu.webflux;

import com.zglu.mongodao.UserMongo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class UserMongoController {

    private final UserMongoService service;

    @GetMapping("/user-mongo/{id}")
    public Mono<UserMongo> get(@PathVariable String id) {
        return service.get(id);
    }

    @PostMapping("/user-mongo")
    public Mono<UserMongo> get(@RequestBody UserMongo user) {
        return service.add(user);
    }
}
