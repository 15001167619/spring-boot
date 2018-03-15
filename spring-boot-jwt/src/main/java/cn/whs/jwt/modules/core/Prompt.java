package cn.whs.jwt.modules.core;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-15 13:46
 */
public abstract class Prompt {

    protected int code;
    protected String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
