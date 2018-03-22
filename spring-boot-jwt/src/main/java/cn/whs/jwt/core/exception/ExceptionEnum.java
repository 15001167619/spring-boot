package cn.whs.jwt.core.exception;

/**
 * @author 武海升
 * @version 2.0
 * @description  具体业务异常封装
 * @date 2018-03-17 10:40
 */
public enum ExceptionEnum  implements ServiceExceptionEnum{

    /**
     * token异常
     */
    TOKEN_EXPIRED(700, "token过期"),
    TOKEN_ERROR(700, "token验证失败"),

    /**
     * 签名异常
     */
    SIGN_ERROR(700, "签名验证失败"),

    /**
     * 其他
     */
    WRITE_ERROR(500,"渲染界面错误"),
    AUTH_REQUEST_ERROR(400, "账号密码错误"),

    /**
     * 错误的请求
     */
    REQUEST_NULL(400, "请求有错误"),
    SERVER_ERROR(500, "服务器异常"),

    /**
     * 账户问题
     */
    USER_ALREADY_REG(401,"该用户已经注册"),
    NO_THIS_USER(400,"没有此用户"),
    USER_NOT_EXISTED(400, "没有此用户"),
    ACCOUNT_FREEZED(401, "账号被冻结"),
    OLD_PWD_NOT_RIGHT(402, "原密码不正确"),
    TWO_PWD_NOT_MATCH(405, "两次输入密码不一致"),

    /**
     * 具体业务  eg：用户sysUser
     */
    TEST(250,"TipsRuntimeException 第二种展示方式"),
    TEST_TRANSACTIONAL(500,"Transactional 事物");


    ExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;

    private String message;

    @Override
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
