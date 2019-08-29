package com.zglu.springboot.solr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserSolrController {

    private final UserSolrService service;

    @Autowired
    public UserSolrController(UserSolrService userSolrService) {
        this.service = userSolrService;
    }

    @GetMapping("/user-solr/{id}")
    public UserSolr get(@PathVariable int id) {
        return service.get(id);
    }

    @PostMapping("/user-solr")
    public UserSolr get(UserSolr user) {
        return service.add(user);
    }
}
