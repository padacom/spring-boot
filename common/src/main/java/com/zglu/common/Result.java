package com.zglu.common;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class Result<T> {

    private int status;
    private String message;
    private T data;

    private Result(CustomException e) {
        status = e.getStatus();
        message = e.getMessage();
    }

    private Result(ResultCode r, T e) {
        status = r.status();
        message = r.message();
        data = e;
    }

    private Result(Map<String, Object> m, T e) {
        status = Integer.parseInt(m.get("status") + "");
        message = m.get("error") + "";
        data = e;
    }

    public static Result fail(CustomException e) {
        return new Result(e);
    }

    public static Result exception(Exception e) {
        return new Result<>(ResultCode.EXCEPTION, e.getMessage());
    }

    public static Result exception(Map<String, Object> e) {
        return new Result<>(e, e);
    }
}
