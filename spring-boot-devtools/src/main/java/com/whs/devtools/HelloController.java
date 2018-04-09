package com.whs.devtools;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-04-09 18:13
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        // System.out.println("test");
        return "Hello World";
    }

}
