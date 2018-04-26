package com.whs.beetl.modules.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-04-25 14:29
 */
@Controller
@RequestMapping(value = "index")
public class IndexController {

    private String PREFIX = "/system/aaa/";

    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("hi","Beetl Test");
        return "index";
    }

}
