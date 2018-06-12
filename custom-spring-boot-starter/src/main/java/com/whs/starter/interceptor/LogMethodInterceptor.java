package com.whs.starter.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-06-12 10:13
 */
public class LogMethodInterceptor implements MethodInterceptor {

    private Logger logger = LoggerFactory.getLogger(LogMethodInterceptor.class);
    private List<String> exclude;
    public LogMethodInterceptor(String[] exclude) {
        this.exclude = Arrays.asList(exclude);
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        Object[] arguments = methodInvocation.getArguments();
        if(arguments!=null){
            for(Object parameter :arguments){
                System.out.println("------------参数值------------ "+ parameter);
            }
        }

        String methodName = methodInvocation.getMethod().getName();
        if(exclude.contains(methodName)) {
            return methodInvocation.proceed();
        }
        long start = System.currentTimeMillis();
        Object result = methodInvocation.proceed();
        long end = System.currentTimeMillis();
        logger.info("====method({}), cost({}) ", methodName, (end - start));
        return result;
    }
}
