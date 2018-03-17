package cn.whs.jwt.core.exception;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-17 10:40
 */
public interface ServiceExceptionEnum {
    /**
     * 获取异常编码
     */
    Integer getCode();

    /**
     * 获取异常信息
     */
    String getMessage();

}
