package cn.whs.db.modules.core.controller;

import cn.whs.db.common.CommonUtils;
import cn.whs.db.modules.core.entity.CoreUser;
import cn.whs.db.modules.core.service.ICoreUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-28 16:24
 */
@RestController
@RequestMapping("coreUser")
@Slf4j
public class CoreUserController {

    @Autowired
    private ICoreUserService coreUserService;

    @RequestMapping(value="add", method= RequestMethod.POST)
    public Object add() {
        coreUserService.insert(new CoreUser(1+(int)(Math.random()*20),"whs"+ CommonUtils.getRandomString(3),CommonUtils.getRandomString(11),CommonUtils.getRandomString(6)));
        return "success";
    }

}
