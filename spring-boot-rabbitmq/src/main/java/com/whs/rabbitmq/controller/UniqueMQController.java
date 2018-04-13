package com.whs.rabbitmq.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-04-13 10:28
 */
@RestController
public class UniqueMQController {


    @RequestMapping("/hello")
    public void sayHi() {
        //senderService.send();
    }
}
