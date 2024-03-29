package com.zglu.common;

public enum ResultCode {

    EXCEPTION(-1, "服务器异常"),
    FAIL(0, "失败"),

    //通用
    DATA_NOT_EXIST(10001, "数据不存在"),

    //用户模块
    USER_TOKEN_ERROR(20001, "令牌认证失败"),
    USER_NOT_EXIST(20002, "用户不存在"),
    USER_LOGIN_ERROR(20003, "用户密码错误"),
    USER_DISABLE(20004, "用户已被禁用"),

    //权限模块
    PERMISSION_NOT_EXIST(30001, "权限不存在"),
    USER_NOT_PERMISSION(30002, "用户无此权限"),

    SUCCESS(1, "成功");

    private int status;
    private String message;

    ResultCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int status() {
        return status;
    }

    public String message() {
        return message;
    }
}