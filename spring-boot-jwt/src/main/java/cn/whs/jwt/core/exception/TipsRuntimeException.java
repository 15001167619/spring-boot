package cn.whs.jwt.core.exception;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-17 10:32
 */
public class TipsRuntimeException extends RuntimeException  {

    private Integer code;

    private String message;

    public TipsRuntimeException(ServiceExceptionEnum serviceExceptionEnum) {
        this.code = serviceExceptionEnum.getCode();
        this.message = serviceExceptionEnum.getMessage();
    }

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
