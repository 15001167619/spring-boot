package cn.whs.jwt.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 武海升
 * @version 2.0
 * @description
 *       @ControllerAdvice拦截异常;
 *       @ExceptionHandler指定处理哪种异常（可指定多个）;
 *       @ResponseStatus指定返回的http状态码（具体可查看HttpStatus这个类）;
 *       @ControllerAdvice+@ResponseBody可换成@RestControllerAdvice
 * @date 2018-03-17 10:33
 */
@RestControllerAdvice
public class TipsExceptionHandler {

    /**
     * 通过注解拦截异常  ExceptionHandler @ExceptionHandler(TipsException.class)
     * 注：注意ControllerAdvice只能捕获到全局Controller范围内的，之外的异常无法捕获，
     * 如filter中抛出异常的话，ControllerAdvice是无法捕获的。需要实现 ErrorController并注册为controller。
     */
    @ExceptionHandler(TipsException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handlerTipsException(TipsException ex) {
        Map<String,Object> result = new HashMap<>();
        result.put("message", ex.getMessage());
        result.put("error type", "TipsException 第一种展示方式");
        return result;
    }



    /**
     * 自定义枚举异常
     */
    @ExceptionHandler(TipsRuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handlerMyRuntimeException(TipsRuntimeException ex) {
        Map<String,Object> result = new HashMap<>();
        result.put("code", ex.getCode());
        result.put("message", ex.getMessage());
        return result;
    }

}
