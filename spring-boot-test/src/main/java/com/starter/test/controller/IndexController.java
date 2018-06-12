package com.starter.test.controller;

import com.starter.test.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-06-12 10:40
 */
@Controller
public class IndexController {

    @Autowired
    private LogService logService;

    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index(Model model) {
        logService.test(666,"慕小谦");
        logService.core(666);
        logService.work(666);
        model.addAttribute("msg","starter test");
        return "index";
    }

}
