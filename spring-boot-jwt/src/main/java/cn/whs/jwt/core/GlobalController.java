package cn.whs.jwt.core;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-15 16:01
 */
@Controller
@RequestMapping("/global")
public class GlobalController {

    /**
     * 跳转到主页
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        return "/index.html";
    }

    /**
     * 跳转到404页面
     */
    @RequestMapping(path = "/error")
    public String errorPage() {
        return "/404.html";
    }


}
