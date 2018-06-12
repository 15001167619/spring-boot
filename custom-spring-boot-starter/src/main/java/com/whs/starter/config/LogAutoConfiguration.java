package com.whs.starter.config;

import com.whs.starter.aspect.Log;
import com.whs.starter.interceptor.LogMethodInterceptor;
import com.whs.starter.properties.LogProperties;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-06-12 10:03
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(LogProperties.class)
public class LogAutoConfiguration extends AbstractPointcutAdvisor {

    private Pointcut pointcut;

    private Advice advice;

    @Autowired
    private LogProperties logProperties;

    @PostConstruct
    public void init() {
        log.info("init LogAutoConfiguration start");
        this.pointcut = new AnnotationMatchingPointcut(null, Log.class);
        this.advice = new LogMethodInterceptor(logProperties.getExcludeArr());
        log.info("init LogAutoConfiguration end");
    }


    @Override
    public Pointcut getPointcut() {
        return this.pointcut;
    }

    @Override
    public Advice getAdvice() {
        return this.advice;
    }
}
