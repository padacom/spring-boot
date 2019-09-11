package com.zglu.springboot.controller;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
class Test2Vo extends TestBaseVo {
    private String sex;
}
