package com.zglu.therror.api;

import com.zglu.common.CustomException;
import com.zglu.common.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("com.zglu.therror.api")
public class TestRestControllerAdvice {

    //拦截控制器抛出业务异常
    @ExceptionHandler(CustomException.class)
    public Result customException(CustomException e) {
        return Result.fail(e);
    }

    //拦截控制器抛出未知异常
    @ExceptionHandler(Exception.class)
    public Result unknownException(Exception e) {
        e.printStackTrace();
        return Result.exception(e);
    }
}
