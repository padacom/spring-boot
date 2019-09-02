package com.zglu.springboot.controller;

import com.zglu.springboot.common.CustomException;
import com.zglu.springboot.common.ResultCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/test")
    public String test(Model model) {
        return "test";
    }

    @GetMapping("/1")
    public String test1() {
        throw new CustomException(ResultCode.DATA_NOT_EXIST);
    }

    @GetMapping("/2")
    public String test2() {
        throw new RuntimeException("未知异常");
    }
}
