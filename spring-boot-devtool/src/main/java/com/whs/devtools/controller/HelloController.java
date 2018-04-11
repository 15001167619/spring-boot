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

    @RequestMapping("/say80")
    public String hello80() {
        return "武海升80...";
    }

    @RequestMapping("/say81")
    public String hello81() {
        return "武海升81....";
    }

    @RequestMapping("/say82")
    public String hello82() {
        return "武海升82";
    }


}
