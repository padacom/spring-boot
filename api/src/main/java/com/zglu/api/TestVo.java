package com.zglu.api;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
class TestVo extends TestBaseVo {
    private String phone;

    public void set(String s) {
        super.set(s);
        phone = s;
    }
}
