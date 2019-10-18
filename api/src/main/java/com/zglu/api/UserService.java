package com.zglu.api;

import com.alibaba.fastjson.JSON;
import com.zglu.mysqldao.*;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log
@Service
@AllArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final RoleService service;

    @Cacheable(cacheManager = "cacheManager", value = "user", key = "'id:'+#id")
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

    public List<UserRoleVo> userRole(int id) {
        List o = userRepo.findUserRoleVoListById(id);
        return JSON.parseArray(JSON.toJSONString(o), UserRoleVo.class);
    }

    public List<UserRoleVo> userRoleHql(int id) {
        return userRepo.findUserRoleVoListForHqlById(id);
    }

    public List<UserVo> findVoById(int id) {
        return userRepo.findVoById(id);
    }

    public int update() {
        return userRepo.update();
    }
}
