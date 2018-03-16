package cn.whs.jwt.modules.controller;

import cn.whs.jwt.core.BaseController;
import cn.whs.jwt.modules.entity.SysUser;
import cn.whs.jwt.modules.service.ISysUserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Slf4j
public class SysUserController extends BaseController {

    @Autowired
    private ISysUserService sysUserService;

    /**
     * 获取用户列表
     */
    @ApiOperation(value="获取用户列表", notes="测试获取用户列表")
    @RequestMapping(value={""}, method=RequestMethod.GET)
    public Object list() {
        return sysUserService.selectList(null);
    }

    /**
     * 新增用户
     */
    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @RequestMapping(value="add", method=RequestMethod.POST)
    public Object add(@RequestBody SysUser sysUser) {
        log.info("参数 sysUser："+sysUser);
        sysUserService.insert(sysUser);
        return SUCCESS_PROMPT;
    }

    @ApiOperation(value="获取用户详细信息", notes="根据用户id来获取用户详细信息")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public SysUser getUser(@ApiParam(required = true, name = "id", value = "用户ID") @RequestParam(value = "id", required = true) Integer id) {
        return sysUserService.selectById(id);
    }

    /**
     * 更新用户
     */
    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public Object putUser(@ApiParam(required = true, name = "id", value = "用户ID") @RequestParam(value = "id", required = true) Integer id, @RequestBody SysUser user) {
        SysUser sysUser = sysUserService.selectById(id);
        sysUser.setName(user.getName());
        sysUser.setAge(user.getAge());
        sysUserService.updateById(sysUser);
        return SUCCESS_PROMPT;
    }
    /**
     * 删除用户
     */
    @ApiOperation(value="删除用户", notes="根据用户id来指定删除对象")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public Object delete(@ApiParam(required = true, name = "id", value = "用户ID") @RequestParam(value = "id", required = true) Integer id) {
        sysUserService.deleteById(id);
        return SUCCESS_PROMPT;
    }
}
