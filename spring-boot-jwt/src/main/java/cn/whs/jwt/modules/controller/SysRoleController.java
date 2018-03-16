package cn.whs.jwt.modules.controller;

import cn.whs.jwt.core.BaseController;
import cn.whs.jwt.modules.entity.SysRole;
import cn.whs.jwt.modules.service.ISysRoleService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * 新增用户
     */
    @ApiOperation(value="创建角色", notes="根据Role对象创建角色")
    @RequestMapping(value="add", method= RequestMethod.POST)
    public Object add(@RequestBody SysRole sysRole) {
        sysRoleService.insert(sysRole);
        return SUCCESS_PROMPT;
    }

}
