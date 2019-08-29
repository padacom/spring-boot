package com.zglu.springboot.solr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSolrService {

    private final UserSolrRepo repo;

    @Autowired
    public UserSolrService(UserSolrRepo repo) {
        this.repo = repo;
    }

    public UserSolr get(int id) {
        return repo.findById(id).orElse(null);
    }

    public UserSolr add(UserSolr userSolr) {
        return repo.save(userSolr);
    }
}
