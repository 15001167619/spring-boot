package cn.whs.jwt.modules.controller;

import cn.whs.jwt.modules.core.BaseController;
import cn.whs.jwt.modules.entity.SysUser;
import cn.whs.jwt.modules.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-15 21:45
 */
@Controller
@RequestMapping("user")
public class SysUserController extends BaseController {

    @Autowired
    private ISysUserService sysUserService;

    /**
     * 获取用户列表
     */
    @RequestMapping(value = "list")
    @ResponseBody
    public Object list() {
        return sysUserService.selectList(null);
    }

    /**
     * 新增测试
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Object add(Integer age,String name) {
        sysUserService.insert(new SysUser(age,name));
        return SUCCESS_PROMPT;
    }

    /**
     * 删除测试
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Object delete(@RequestParam Integer sysUserId) {
        sysUserService.deleteById(sysUserId);
        return SUCCESS_PROMPT;
    }

    /**
     * 修改测试
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Object update(Integer id,Integer age,String name) {
        sysUserService.updateById(new SysUser(id,age,name));
        return SUCCESS_PROMPT;
    }
}
