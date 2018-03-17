package cn.whs.jwt.modules.controller;

import cn.whs.jwt.core.BaseController;
import cn.whs.jwt.modules.entity.SysRole;
import cn.whs.jwt.modules.entity.SysRoleUser;
import cn.whs.jwt.modules.service.ISysRoleService;
import cn.whs.jwt.modules.service.ISysRoleUserService;
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
 * @date 2018-03-16 18:05
 */
@RestController
@RequestMapping("role")
@Slf4j
public class SysRoleController  extends BaseController {

    @Autowired
    private ISysRoleService sysRoleService;

    @Autowired
    private ISysRoleUserService sysRoleUserService;

    /**
     * 新增角色
     */
    @ApiOperation(value="创建角色", notes="根据Role对象创建角色")
    @RequestMapping(value="add", method= RequestMethod.POST)
    public Object add(@RequestBody SysRole sysRole) {
        sysRoleService.insert(sysRole);
        return SUCCESS_PROMPT;
    }

    /**
     * 获取角色列表
     */
    @ApiOperation(value="获取角色列表", notes="测试获取角色列表")
    @RequestMapping(value={""}, method=RequestMethod.GET)
    public Object list(@ApiParam(required = true, name = "page", value = "当前页码") @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                       @ApiParam(required = true, name = "rows", value = "每页条数") @RequestParam(value = "rows", defaultValue = "3") Integer rows,
                       @ApiParam(required = false, name = "userId", value = "用户Id") @RequestParam(value = "userId", required = false) Integer  userId,
                       @ApiParam(required = false, name = "roleId", value = "角色Id") @RequestParam(value = "roleId", required = false) Integer roleId) {
        if(roleId!=null||userId!=null){
            EntityWrapper<SysRoleUser> ew = new EntityWrapper<SysRoleUser>();
            ew.setEntity(new SysRoleUser());
            if(userId!=null)ew.eq("userId",userId);
            if(roleId!=null)ew.eq("roleId",roleId);
            return findDataPage(sysRoleUserService.selectSysRoleUserPage(new Page<SysRoleUser>(pageNum, rows), ew));
        }
        return findDataPage(sysRoleUserService.selectSysRoleUserPage(new Page<SysRoleUser>(pageNum, rows), null));
    }


    

}
