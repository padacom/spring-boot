package com.zglu.therror.api;

import com.zglu.common.CustomException;
import com.zglu.common.ResultCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

    @GetMapping("/api")
    public String test() {
        return "test";
    }

    @GetMapping("/api/1")
    public String test1() {
        throw new CustomException(ResultCode.DATA_NOT_EXIST);
    }

    @GetMapping("/api/2")
    public String test2() {
        throw new RuntimeException();
    }

    @PostMapping("/api/3")
    public void test3() {
    }
}
