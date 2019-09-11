package com.zglu.springboot.config;

import com.zglu.springboot.common.Result;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@AllArgsConstructor
public class CustomErrorController implements ErrorController {

    private ErrorAttributes errorAttributes;

    @Override
    public String getErrorPath() {
        return "error";
    }

    //页面渲染时，拦截非控制器抛出异常
    @RequestMapping(value = "error", produces = "text/html")
    public String error(HttpServletRequest request, Model model) {
        Map<String, Object> e = getErrorAttributes(request, false);
        Result result = Result.exception(e);
        model.addAttribute("e", result);
        return getErrorPath();
    }

    //接口调用时，拦截非控制器抛出异常
    @ResponseBody
    @RequestMapping("error")
    public Result restError(HttpServletRequest request, Model model) {
        Map<String, Object> e = getErrorAttributes(request, false);
        return Result.exception(e);
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
        ServletWebRequest servletWebRequest = new ServletWebRequest(request);
        return this.errorAttributes.getErrorAttributes(servletWebRequest, includeStackTrace);
    }
}
