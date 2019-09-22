package com.zglu.mongodao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMongoRepo extends ReactiveMongoRepository<UserMongo, String> {

}