package com.zglu.springboot.solr;

import org.springframework.data.solr.repository.SolrCrudRepository;

public interface UserSolrRepo extends SolrCrudRepository<UserSolr, Integer> {
}
