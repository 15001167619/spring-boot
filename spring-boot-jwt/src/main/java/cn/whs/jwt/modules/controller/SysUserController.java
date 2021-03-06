package cn.whs.jwt.modules.controller;

import cn.whs.jwt.core.BaseController;
import cn.whs.jwt.core.exception.ExceptionEnum;
import cn.whs.jwt.core.exception.TipsRuntimeException;
import cn.whs.jwt.modules.entity.SysUser;
import cn.whs.jwt.modules.service.ISysUserService;
import cn.whs.jwt.utils.CommonUtils;
import cn.whs.jwt.utils.MD5Util;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
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
    public Object list(@ApiParam(required = true, name = "page", value = "当前页码") @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                       @ApiParam(required = true, name = "rows", value = "每页条数") @RequestParam(value = "rows", defaultValue = "3") Integer rows,
                       @ApiParam(required = false, name = "age", value = "年龄") @RequestParam(value = "age", required = false) Integer age,
                       @ApiParam(required = false, name = "name", value = "姓名") @RequestParam(value = "name", required = false) String name) {
        if(CommonUtils.isNotBlank(name)||age!=null){
            EntityWrapper<SysUser> ew = new EntityWrapper<SysUser>();
            ew.setEntity(new SysUser());
            ew.where("age<{0}",age)
                    .like("name",name).orderBy("age");
            return findDataPage(sysUserService.selectPage(new Page<SysUser>(pageNum, rows), ew));
        }
        return findDataPage(sysUserService.selectPage(new Page<SysUser>(pageNum, rows)));
    }

    /**
     * 新增用户
     */
    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @RequestMapping(value="auth/add", method=RequestMethod.POST)
    public Object add(@RequestBody SysUser sysUser,
                      @ApiParam(required = true, name = "authToken", value = "Token令牌") @RequestParam(value = "authToken") String authToken) {
        log.info("参数 token："+authToken);
        log.info("参数 sysUser："+sysUser);
        sysUser.setSalt(CommonUtils.getRandomString(5));
        sysUser.setPassword(MD5Util.md5(sysUser.getPassword(), sysUser.getSalt()));
        sysUserService.insert(sysUser);
        return SUCCESS_PROMPT;
    }

    /**
     * 修改当前用户的密码
     */
    @ApiOperation(value="修改用户密码", notes="修改用户密码")
    @RequestMapping(value="changePwd", method=RequestMethod.POST)
    public Object changePwd(@ApiParam(required = true, name = "userId", value = "用户ID") @RequestParam(value = "userId") Integer userId,
                            @ApiParam(required = true, name = "oldPwd", value = "旧密码") @RequestParam(value = "oldPwd") String oldPwd,
                            @ApiParam(required = true, name = "newPwd", value = "新密码") @RequestParam(value = "newPwd") String newPwd) {
        SysUser sysUser = sysUserService.selectById(userId);
        String oldMd5 = MD5Util.md5(oldPwd, sysUser.getSalt());
        if (sysUser.getPassword().equals(oldMd5)) {
            String newMd5 = MD5Util.md5(newPwd, sysUser.getSalt());
            sysUser.setPassword(newMd5);
            sysUser.updateById();
            return SUCCESS_PROMPT;
        } else {
            throw new TipsRuntimeException(ExceptionEnum.OLD_PWD_NOT_RIGHT);
        }
    }

    @ApiOperation(value="事物更新用户", notes="具有事物级别的更新用户")
    @RequestMapping(value="updateSysUser", method=RequestMethod.POST)
    public Object updateSysUser(@RequestBody SysUser sysUser) {
        sysUserService.updateSysUser(sysUser);
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
