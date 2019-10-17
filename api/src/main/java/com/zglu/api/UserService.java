package com.zglu.api;

import com.zglu.mysqldao.Role;
import com.zglu.mysqldao.UserRepo;
import com.zglu.mysqldao.User;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log
@Service
@AllArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final RoleService service;

    @Cacheable(value = "user", key = "'id:'+#id")
    public User get(int id) {
        log.info("db");
        return userRepo.findById(id).orElse(new User());
    }

    //测试事务
    @Transactional
    @CacheEvict(value = "user", allEntries = true)
    public User add(User user) {
        service.add(new Role());
        return userRepo.save(user);
    }
}
