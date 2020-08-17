package com.yglong.sbms.core.exception;

public class SbmsException extends RuntimeException {

    private String msg;
    private int code = 500;

    public SbmsException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public SbmsException(String msg, Throwable t) {
        super(msg, t);
        this.msg = msg;
    }

    public SbmsException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public SbmsException(String msg, int code, Throwable t) {
        super(msg, t);
        this.msg = msg;
        this.code = code;
    }

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
