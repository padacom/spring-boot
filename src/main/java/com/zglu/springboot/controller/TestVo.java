package com.zglu.springboot.controller;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TestVo extends TestBaseVo {
    private String phone;
}
