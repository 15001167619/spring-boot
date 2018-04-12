package com.whs.async.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-04-12 9:24
 */
@Slf4j
public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        log.error("Async method has uncaught exception, params:{}" + Arrays.toString(params));

        if (ex instanceof AsyncExceptionTip) {
            AsyncExceptionTip asyncException = (AsyncExceptionTip) ex;
            log.error("asyncException:"  + asyncException.getMessage());
        }
        log.error("Exception :", ex);

    }
}
