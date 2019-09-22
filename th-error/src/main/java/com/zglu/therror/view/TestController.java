package com.zglu.therror.view;

import com.zglu.common.CustomException;
import com.zglu.common.ResultCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {

    @GetMapping
    public String test(Model model) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        model.addAttribute("o", map);
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

    @GetMapping("/3")
    public String test3() {
        return "test";
    }
}
