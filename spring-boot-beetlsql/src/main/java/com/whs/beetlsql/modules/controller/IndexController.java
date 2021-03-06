package com.whs.beetlsql.modules.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-05-24 9:11
 */
@Controller
public class IndexController {

    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("hi","Beetlsql User首页测试!");
        return "index";
    }

}
