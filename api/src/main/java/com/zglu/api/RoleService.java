package com.zglu.api;

import com.zglu.mysqldao.RoleRepo;
import com.zglu.mysqldao.Role;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Log
@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepo roleRepo;

    @CacheEvict(value = "role", allEntries = true)
    public Role add(Role role) {
        return roleRepo.save(role);
    }
}
