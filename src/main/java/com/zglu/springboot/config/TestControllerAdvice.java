package com.zglu.springboot.config;

import com.zglu.springboot.common.CustomException;
import com.zglu.springboot.common.Result;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice("com.zglu.springboot.view")
public class TestControllerAdvice {

    //统一为页面配置model
    @ModelAttribute
    public void modelAttribute(Model model) {
        model.addAttribute("m", "test");
    }

    //拦截控制器抛出业务异常
    @ExceptionHandler(CustomException.class)
    public String customException(CustomException e, Model model) {
        Result result = Result.fail(e);
        model.addAttribute("e", result);
        return "error";
    }

    //拦截控制器抛出未知异常
    @ExceptionHandler(Exception.class)
    public String exception(Exception e, Model model) {
        e.printStackTrace();
        Result result = Result.exception(e);
        model.addAttribute("e", result);
        return "error";
    }
}
