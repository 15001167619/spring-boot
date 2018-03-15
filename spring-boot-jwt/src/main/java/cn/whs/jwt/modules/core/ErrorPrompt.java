package cn.whs.jwt.modules.core;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-15 13:48
 */
public class ErrorPrompt extends Prompt{
    public ErrorPrompt(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

}
