package com.whs.resttemplate.modules.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.whs.resttemplate.modules.dao.SysUserMapper;
import com.whs.resttemplate.modules.entity.SysUser;
import com.whs.resttemplate.modules.service.ISysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-15 21:40
 */
@Service
@Transactional(readOnly = true)
public class SysUserServiceimpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
}
