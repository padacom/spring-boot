package com.zglu.springboot.api.solr;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserSolrService {

    private final UserSolrRepo repo;

    UserSolr get(int id) {
        return repo.findById(id).orElse(null);
    }

    UserSolr add(UserSolr userSolr) {
        return repo.save(userSolr);
    }
}
