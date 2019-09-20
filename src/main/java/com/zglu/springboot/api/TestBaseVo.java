package com.zglu.springboot.api;

import lombok.Data;

@Data
class TestBaseVo {
    private String id;
    private String name;

    public void set(String s) {
        name = s;
    }
}
