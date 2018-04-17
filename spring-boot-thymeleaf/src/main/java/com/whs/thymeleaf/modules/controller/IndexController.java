package com.whs.thymeleaf.modules.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-04-17 11:19
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("msg", "welcome you!");
        return "index";
    }

}
