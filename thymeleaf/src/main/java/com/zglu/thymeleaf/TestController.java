package com.zglu.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping
    String test(Model model) {
        model.addAttribute("title", "测试标题");
        model.addAttribute("body", "测试正文");
        return "test";
    }
}
