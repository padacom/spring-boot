package com.zglu.api;

import com.zglu.solrdao.UserSolr;
import com.zglu.solrdao.UserSolrRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserSolrService {

    private final UserSolrRepo userSolrRepo;

    UserSolr get(int id) {
        return userSolrRepo.findById(id).orElse(null);
    }

    UserSolr add(UserSolr userSolr) {
        return userSolrRepo.save(userSolr);
    }
}
