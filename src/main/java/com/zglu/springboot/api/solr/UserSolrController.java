package com.zglu.springboot.api.solr;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserSolrController {

    private final UserSolrService service;

    @GetMapping("/user-solr/{id}")
    public UserSolr get(@PathVariable int id) {
        return service.get(id);
    }

    @PostMapping("/user-solr")
    public UserSolr get(@RequestBody UserSolr user) {
        return service.add(user);
    }
}
