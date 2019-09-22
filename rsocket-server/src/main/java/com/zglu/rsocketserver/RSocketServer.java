package com.zglu.rsocketserver;

import com.zglu.mongodao.UserMongo;
import com.zglu.mongodao.UserMongoRepo;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log
@Controller
@AllArgsConstructor
public class RSocketServer {

    private final UserMongoRepo userMongoRepo;

    @MessageMapping("get")
    public Mono<UserMongo> get(String id) {
        return userMongoRepo.findById(id);
    }

    @MessageMapping("fnf")
    public Mono<Void> fnf() {
        log.info("fnf");
        return Mono.empty();
    }

    @MessageMapping("rs")
    public Flux<UserMongo> rs() {
        return userMongoRepo.findAll();
    }
}
