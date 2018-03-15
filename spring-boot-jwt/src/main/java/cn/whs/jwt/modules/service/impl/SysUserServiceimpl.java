package cn.whs.jwt.modules.service.impl;

import cn.whs.jwt.modules.dao.SysUserMapper;
import cn.whs.jwt.modules.entity.SysUser;
import cn.whs.jwt.modules.service.ISysUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-15 21:40
 */
@Service
public class SysUserServiceimpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
}
