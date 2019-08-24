package com.zglu.springboot.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo repo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.repo = userRepo;
    }

    User get(int id) {
        return repo.findById(id).orElse(null);
    }

    User add(User user) {
        return repo.save(user);
    }
}
