package com.zglu.springboot.api.mongo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserMongoService {

    private final UserMongoRepo repo;

    UserMongo get(String id) {
        return repo.findById(id).block();
    }

    UserMongo add(UserMongo userSolr) {
        return repo.save(userSolr).block();
    }
}
