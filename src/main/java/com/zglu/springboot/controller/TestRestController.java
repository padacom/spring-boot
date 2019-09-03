package com.zglu.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.zglu.springboot.common.CustomException;
import com.zglu.springboot.common.ResultCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

    @GetMapping("/api/test")
    public String test() {
        return "test";
    }

    @GetMapping("/api/1")
    public String test1() {
        throw new CustomException(ResultCode.DATA_NOT_EXIST);
    }

    @GetMapping("/api/2")
    public String test2() {
        throw new RuntimeException("未知异常");
    }

    @GetMapping("/api/vo")
    public TestVo testVo() {
        return new TestVo();
    }

    @PostMapping("/api/vo")
    public TestVo testVo(@RequestBody String json) {
        return JSON.parseObject(json,TestVo.class);
    }
}
