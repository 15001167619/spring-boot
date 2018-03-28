package cn.whs.db.modules.one.controller;

import cn.whs.db.common.CommonUtils;
import cn.whs.db.modules.one.entity.OneUser;
import cn.whs.db.modules.one.service.IOneUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-28 16:25
 */
@RestController
@RequestMapping("oneUser")
@Slf4j
public class OneUserController {

    @Autowired
    private IOneUserService oneUserService;

    @RequestMapping(value="add", method= RequestMethod.POST)
    public Object add() {
        oneUserService.insert(new OneUser(1+(int)(Math.random()*20),"whs"+ CommonUtils.getRandomString(3),CommonUtils.getRandomString(11),CommonUtils.getRandomString(6)));
        return "success";
    }
}
