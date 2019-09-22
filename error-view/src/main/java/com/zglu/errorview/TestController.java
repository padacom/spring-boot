package com.zglu.errorview;

import com.zglu.common.CustomException;
import com.zglu.common.ResultCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/1")
    public String test1() {
        throw new CustomException(ResultCode.DATA_NOT_EXIST);
    }

    @GetMapping("/2")
    public String test2() {
        throw new RuntimeException();
    }
}
