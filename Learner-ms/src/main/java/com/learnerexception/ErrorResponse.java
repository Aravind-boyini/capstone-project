package com.learnerexception;



public class ErrorResponse {
    private String msg;
    private int code;

    public ErrorResponse(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    // Getters and Setters
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}