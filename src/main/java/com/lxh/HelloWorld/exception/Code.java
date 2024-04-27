package com.lxh.HelloWorld.exception;

public enum Code {
    BAD_REQUEST(400, "Request path error"),
    LOGIN_ERROR(400, "Incorrect username and password"),
    UNAUTHORIZED(401, "Not logged in"),
    TOKEN_EXPIRED(403, "Expired, please log in again");


    private final int code;
    private final String message;

    Code(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
