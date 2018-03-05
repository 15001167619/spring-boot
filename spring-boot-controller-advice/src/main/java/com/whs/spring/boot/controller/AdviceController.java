package com.whs.spring.boot.controller;

import com.whs.spring.boot.exception.CustomException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 武海升
 * @version 2.0
 * @description 异常处理入口
 * @date 2018-03-05 10:51
 */
@RestController
@RequestMapping(value = "exceptionOperation")
public class AdviceController {

    @RequestMapping(value = "div")
    public String div() {
        int i = 1 / 0;
        return "success";
    }

    @RequestMapping(value = "length")
    public String length() {
        String string = null;
        string.length();
        return "success";
    }

    @RequestMapping(value = "customException")
    public List<String> hello3() {
        throw new CustomException("自定义异常");
    }

}
