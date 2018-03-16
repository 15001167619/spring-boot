package cn.whs.jwt.modules.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-16 17:22
 */
@Controller
public class IndexController {

    @RequestMapping(value={""}, method= RequestMethod.GET)
    public String updateOrAddProject() {
        return "redirect:swagger-ui.html";
    }

}
