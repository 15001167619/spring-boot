package com.whs.resttemplate.modules.controller;

import com.whs.resttemplate.modules.entity.SysUser;
import com.whs.resttemplate.modules.service.ISysUserService;
import com.whs.resttemplate.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-15 21:45
 */
@RestController
@RequestMapping("user")
@Slf4j
public class SysUserController{

    @Autowired
    private ISysUserService sysUserService;


    /**
     * 新增用户
     */
   @RequestMapping(value="add")
    public String add() {
        SysUser sysUser = new SysUser(1+(int)(Math.random()*20),"whs"+ CommonUtils.getRandomString(3),CommonUtils.getRandomString(11),CommonUtils.getRandomString(6));
        sysUserService.insert(sysUser);
        return "success";
    }

}
