package com.zglu.solrdao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

@Data
@SolrDocument(collection = "zglu_user")
public class UserSolr {
    @Id
    private int id;
}
