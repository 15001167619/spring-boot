package com.whs.devtools.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-04-10 13:08
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "武海升002";
    }

}
