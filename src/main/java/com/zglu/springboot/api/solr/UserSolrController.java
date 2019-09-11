package com.zglu.springboot.api.solr;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserSolrController {

    private final UserSolrService service;

    @GetMapping("/user-solr/{id}")
    public UserSolr get(@PathVariable int id) {
        return service.get(id);
    }

    @PostMapping("/user-solr")
    public UserSolr get(UserSolr user) {
        return service.add(user);
    }
}
