package com.zglu.springboot.api;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
class Test1Vo extends TestBaseVo {
    private String phone;
}