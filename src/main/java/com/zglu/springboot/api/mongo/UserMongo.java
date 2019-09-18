package com.zglu.springboot.api.mongo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "user")
public class UserMongo {
    private String id;
    private String name;
}