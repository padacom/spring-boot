package com.zglu.mongodao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface UserMongoRepo extends ReactiveMongoRepository<UserMongo, String> {

    Flux<UserMongo> queryAllById(String id);

}