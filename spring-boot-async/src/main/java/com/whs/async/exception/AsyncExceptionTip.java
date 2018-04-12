package com.whs.async.exception;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-04-12 9:23
 */
public class AsyncExceptionTip extends RuntimeException {
    public AsyncExceptionTip() {
        super();
    }

    public AsyncExceptionTip(String msg) {
        super(msg);
    }

    public AsyncExceptionTip(int code, String msg) {
        super(msg);
        this.code = code;
    }

    /**
     * 错误代码
     */
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
