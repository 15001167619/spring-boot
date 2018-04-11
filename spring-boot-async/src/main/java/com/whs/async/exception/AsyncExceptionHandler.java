package com.whs.async.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-04-11 17:01
 */
@Slf4j
public class AsyncExceptionHandler  implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
        log.error("异步调用方法参数异常" + Arrays.toString(objects));

        if (throwable instanceof AsyncException) {
            AsyncException asyncException = (AsyncException) throwable;
            log.error("asyncException:"  + asyncException.getMessage());
        }

        log.error("Exception :", throwable);
    }

}
