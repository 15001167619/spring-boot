package cn.whs.jwt.core.exception;

import cn.whs.jwt.core.ErrorPrompt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author 武海升
 * @version 2.0
 * @description 全局的的异常拦截器（拦截所有的控制器）（带有@RequestMapping注解的方法上都会拦截）
 * @date 2018-03-17 14:43
 */
@Slf4j
public class BaseControllerExceptionHandler {

    /**
     * 拦截业务异常
     */
    @ExceptionHandler(TipsRuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorPrompt notFount(TipsRuntimeException e) {
        log.error("业务异常:", e);
        return new ErrorPrompt(e.getCode(), e.getMessage());
    }

    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorPrompt notFount(RuntimeException e) {
        log.error("运行时异常:", e);
        return new ErrorPrompt(ExceptionEnum.SERVER_ERROR.getCode(), ExceptionEnum.SERVER_ERROR.getMessage());
    }
}
