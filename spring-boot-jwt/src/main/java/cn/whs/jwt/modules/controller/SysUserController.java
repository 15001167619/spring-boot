package cn.whs.jwt.modules.controller;

import cn.whs.jwt.core.BaseController;
import cn.whs.jwt.modules.entity.SysUser;
import cn.whs.jwt.modules.service.ISysUserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-15 21:45
 */
@RestController
@RequestMapping("user")
@Slf4j  //https://www.cnblogs.com/weiapro/p/7633645.html
public class SysUserController extends BaseController {

    @Autowired
    private ISysUserService sysUserService;

    /**
     * 获取用户列表
     */
    @ApiOperation(value="获取用户列表", notes="获取全部用户列表")
    @RequestMapping(value = "list")
    public Object list() {
        return sysUserService.selectList(null);
    }

    /**
     * 新增用户
     */
    @ApiOperation(value="新增用户", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "age", value = "用户年龄", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "name", value = "用户姓名", required = true, dataType = "String")
    })
    @RequestMapping(value = "add")
    public Object add(Integer age,String name) {
        log.debug("参数 age："+age+"; name"+name);
        sysUserService.insert(new SysUser(age,name));
        return SUCCESS_PROMPT;
    }

    /**
     * 删除用户
     */
    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "sysUserId", value = "用户ID", required = true, dataType = "Integer")
    @RequestMapping(value="/{sysUserId}", method= RequestMethod.DELETE)
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
