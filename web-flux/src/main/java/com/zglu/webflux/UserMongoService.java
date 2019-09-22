package com.zglu.webflux;

import com.zglu.mongodao.UserMongo;
import com.zglu.mongodao.UserMongoRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UserMongoService {

    private final UserMongoRepo repo;

    Mono<UserMongo> get(String id) {
        return repo.findById(id);
    }

    Mono<UserMongo> add(UserMongo userSolr) {
        return repo.save(userSolr);
    }
}
