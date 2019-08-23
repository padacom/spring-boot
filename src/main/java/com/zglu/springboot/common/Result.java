package com.zglu.springboot.common;

import lombok.Data;

@Data
public class Result<T> {

    private int code;
    private String msg;
    private T data;

    private Result(CustomException e) {
        code = e.getCode();
        msg = e.getMsg();
    }

    private Result(ResultCode t, T e) {
        code = t.code();
        msg = t.msg();
        data = e;
    }

    public static Result fail(CustomException e) {
        return new Result(e);
    }

    public static Result exception(Exception e) {
        return new Result<>(ResultCode.EXCEPTION, e.getMessage());
    }
}
