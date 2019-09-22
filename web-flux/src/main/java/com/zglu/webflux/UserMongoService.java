package com.zglu.webflux;

import com.zglu.mongodao.UserMongo;
import com.zglu.mongodao.UserMongoRepo;
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
