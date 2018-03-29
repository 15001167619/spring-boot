package cn.whs.db.modules.controller;

import cn.whs.db.common.CommonUtils;
import cn.whs.db.modules.entity.CoreUser;
import cn.whs.db.modules.service.ICoreUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-28 16:24
 */
@RestController
@Slf4j
public class CoreUserController {

    @Autowired
    private ICoreUserService coreUserService;

    @RequestMapping(value = "addCoreUser")
    public Object addCoreUser() {
        coreUserService.insert(new CoreUser(1+(int)(Math.random()*20),"whs"+ CommonUtils.getRandomString(3),CommonUtils.getRandomString(11),CommonUtils.getRandomString(6)));
        return "success";
    }

}
