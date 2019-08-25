package com.zglu.springboot.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo repo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.repo = userRepo;
    }

    @Cacheable(value = "user",key = "'id:'+#id")
    public User get(int id) {
        System.out.println("db");
        return repo.findById(id).orElse(null);
    }

    @CacheEvict(value = "user",allEntries = true)
    public User add(User user) {
        return repo.save(user);
    }
}
