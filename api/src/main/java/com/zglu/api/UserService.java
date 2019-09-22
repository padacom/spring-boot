package com.zglu.api;

import com.zglu.mysqldao.UserRepo;
import com.zglu.mysqldao.User;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Log
@Service
@AllArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    @Cacheable(value = "user", key = "'id:'+#id")
    public User get(int id) {
        log.info("db");
        return userRepo.findById(id).orElse(null);
    }

    @CacheEvict(value = "user", allEntries = true)
    public User add(User user) {
        return userRepo.save(user);
    }
}
