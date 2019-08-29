package com.zglu.springboot.solr;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

@Data
@SolrDocument(collection = "zglu_user")
class UserSolr {
    @Id
    private int id;
}
