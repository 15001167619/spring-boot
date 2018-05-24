package com.whs.beetlsql.modules.controller;

import com.whs.beetlsql.common.Parameters;
import com.whs.beetlsql.modules.entity.User;
import com.whs.beetlsql.modules.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-05-24 10:00
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "list")
    public String userListForm(Model model) {
        Parameters parameters = new Parameters();
        parameters.setLimit(Integer.MAX_VALUE);
        model.addAttribute("userList",userService.userPageList(parameters));
        return "modules/userList";
    }

    @RequestMapping(value = "addUserForm")
    public String addUserForm() {
        return "modules/userAdd";
    }

    @RequestMapping(value = "addUser")
    @ResponseBody
    public Boolean addUser(String userName,String mobile) {
        userService.addUser(new User(userName,mobile));
        return true;
    }
}