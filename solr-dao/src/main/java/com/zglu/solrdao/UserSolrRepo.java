package com.zglu.solrdao;

import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSolrRepo extends SolrCrudRepository<UserSolr, Integer> {

}
