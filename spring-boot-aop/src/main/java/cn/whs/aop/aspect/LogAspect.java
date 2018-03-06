package cn.whs.aop.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author 武海升
 * @version 2.0
 * @description  日志切面
 * @date 2018-03-06 16:12
 */
@Aspect
@Component
public class LogAspect {

    public static Log log = LogFactory.getLog(LogAspect.class);

    @Pointcut("execution(public * cn.whs.aop.controller.*.*(..))")
    public void operationLog(){}

    /**
     *发送请求之前
     */
    @Before("operationLog()")
    public void doRequestBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 请求内容
        log.info("##########################请求内容###########################" );
        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    /**
     *发送请求之后
     */
    @AfterReturning(returning = "ret", pointcut = "operationLog()")
    public void doRequestAfter(Object ret){
        log.info("##########################返回内容###########################" );
        log.info("ret : " + ret);
    }

    /**
     *后置异常通知
     */
    @AfterThrowing("operationLog()")
    public void doRequestException(JoinPoint joinPoint){
        log.info("##########################发生异常###########################" );
    }

    /**
     *后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
     */
    @After("operationLog()")
    public void after(JoinPoint joinPoint){
        log.info("##########################最后执行方法###########################" );
    }

    /**
     *  环绕通知需要携带 ProceedingJoinPoint 类型的参数
     *  环绕通知 类似于  动态代理的全过程
     *  ProceedingJoinPoint：可以决定是否执行目标方法
     *  环绕通知必须有返回值，返回值即为目标方法的返回值
     */
    @Around("operationLog()")
    public Object arround(ProceedingJoinPoint proceedingJoinPoint) {
        Object result = null;
        String methodName = proceedingJoinPoint.getSignature().getName();
        log.info("##########################环绕通知###########################" );
        //执行目标方法
        try {
            //前置通知
            log.info("##########################前置通知###########################" );
            log.info("The method " + methodName + "begin with" + Arrays.asList(proceedingJoinPoint.getArgs()));
            result = proceedingJoinPoint.proceed();
            //后置通知
            log.info("##########################后置通知###########################" );
            log.info("The method " + methodName + "end with" + result );
        } catch (Throwable e) {
            //异常通知
            log.info("##########################异常通知###########################" );
            log.info("The method occurs exception : " + e );
            throw new RuntimeException();
        }
        //后置通知
        log.info("##########################后置通知###########################" );
        log.info("The method " + methodName + "end with" + result );
        return result;
    }



}
