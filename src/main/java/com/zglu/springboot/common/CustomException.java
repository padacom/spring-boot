package com.zglu.springboot.common;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomException extends RuntimeException {

    private int code;
    private String msg;

    public CustomException(ResultCode r) {
        code = r.code();
        msg = r.message();
    }
}
