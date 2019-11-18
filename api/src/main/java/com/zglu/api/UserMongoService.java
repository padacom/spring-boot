package com.zglu.api;

import com.zglu.mongodao.UserMongo;
import com.zglu.mongodao.UserMongoRepo;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Log
@Service
@AllArgsConstructor
public class UserMongoService {

    private final UserMongoRepo userMongoRepo;

    public Flux<UserMongo> getUserMongo(String id){
//        if(StringUtils.isNotEmpty(id)){
//////            UserMongo param = new UserMongo();
//////            param.setId(id);
//////            Example<UserMongo> example = Example.of(param);
////            return userMongoRepo.queryAllById(id);
////        }else{
////            return userMongoRepo.findAll();
////        }
        return userMongoRepo.queryAllById(id);
    }

}
