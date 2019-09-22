package com.zglu.common;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class CustomException extends RuntimeException {

    private int status;
    private String message;

    public CustomException(ResultCode r) {
        super();
        status = r.status();
        message = r.message();
    }
}
