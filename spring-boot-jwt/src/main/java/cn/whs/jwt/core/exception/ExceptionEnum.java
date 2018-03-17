package cn.whs.jwt.core.exception;

/**
 * @author 武海升
 * @version 2.0
 * @description  具体业务异常封装
 * @date 2018-03-17 10:40
 */
public enum ExceptionEnum  implements ServiceExceptionEnum{

    /**
     * 错误的请求
     */
    REQUEST_NULL(400, "请求有错误"),
    SERVER_ERROR(500, "服务器异常"),

    /**
     * 具体业务  eg：用户sysUser
     */
    TEST(250,"TipsRuntimeException 第二种展示方式"),
    TEST_TRANSACTIONAL(500,"Transactional 事物"),
    USER_ALREADY_REG(401,"该用户已经注册"),
    USER_NOT_EXISTED(400, "没有此用户");


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
