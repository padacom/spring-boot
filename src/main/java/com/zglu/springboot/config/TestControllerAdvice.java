package com.zglu.springboot.config;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class TestControllerAdvice {

    //统一为页面配置model
    @ModelAttribute
    public void customException(Model model) {
        model.addAttribute("a", 1);
    }
}
