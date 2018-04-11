package com.whs.async.exception;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-04-11 17:05
 */
public class AsyncException extends RuntimeException  {

    public AsyncException() {
        super();
    }

    public AsyncException(String msg) {
        super(msg);
    }

    public AsyncException(int code, String msg) {
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
