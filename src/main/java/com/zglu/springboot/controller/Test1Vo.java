package com.zglu.springboot.controller;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
class Test1Vo extends TestBaseVo {
    private String phone;
}
