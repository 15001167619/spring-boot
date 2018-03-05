package com.whs.spring.boot.exception;

/**
 * @author 武海升
 * @version 2.0
 * @description 自定义异常类
 *spring 对于 RuntimeException 异常才会进行事务回滚
 * @date 2018-03-05 13:37
 */
public class CustomException  extends RuntimeException {

    public CustomException(String msg) {
        super(msg);
    }

}
