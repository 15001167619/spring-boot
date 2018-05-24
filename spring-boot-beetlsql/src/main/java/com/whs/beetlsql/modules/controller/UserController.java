package com.whs.beetlsql.modules.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-05-24 10:00
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

    /**
     * 跳转到首页
     */
    @RequestMapping(value = "list")
    public String index(Model model) {
        model.addAttribute("hi","Beetl Test");
        return "modules/userList";
    }

}
