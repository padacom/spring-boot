package com.zglu.springboot.config;

import com.zglu.springboot.common.CustomException;
import com.zglu.springboot.common.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TestRestControllerAdvice {

    //拦截业务异常
    @ExceptionHandler(CustomException.class)
    public Result customException(CustomException e) {
        return Result.fail(e);
    }

    //拦截未知异常
    @ExceptionHandler(Exception.class)
    public Result unknownException(Exception e) {
        return Result.exception(e);
    }
}
