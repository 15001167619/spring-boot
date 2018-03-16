package cn.whs.jwt.modules.service.impl;

import cn.whs.jwt.modules.dao.SysRoleMapper;
import cn.whs.jwt.modules.entity.SysRole;
import cn.whs.jwt.modules.service.ISysRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-16 18:03
 */
@Service
public class SysRoleServiceimpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {
}
