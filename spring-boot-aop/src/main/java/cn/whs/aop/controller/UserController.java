package cn.whs.aop.controller;

import cn.whs.aop.aspect.UserAccess;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-06 16:47
 */
@RestController
public class UserController {

    @RequestMapping(value = "doFirstRequest")
    public Object doFirstRequest() {
        return "doFirstRequest controller success";
    }

    @RequestMapping(value = "doRequestException")
    public Object doRequestException() {
        return 1 / 0;
    }

    @RequestMapping(value = "doRequestAnnotation")
    @UserAccess(desc = "注解类")
    public Object doRequestAnnotation() {
        return "doRequestAnnotation controller success";
    }

}
