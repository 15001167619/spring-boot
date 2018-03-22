package cn.whs.jwt.modules.service.impl;

import cn.whs.jwt.core.config.mutidatasource.DbEnum;
import cn.whs.jwt.core.config.mutidatasource.annotion.DataSource;
import cn.whs.jwt.core.exception.TipsRuntimeException;
import cn.whs.jwt.modules.dao.SysUserMapper;
import cn.whs.jwt.modules.entity.SysUser;
import cn.whs.jwt.modules.service.ISysUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static cn.whs.jwt.core.exception.ExceptionEnum.TEST_TRANSACTIONAL;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-15 21:40
 */
@Service
@Transactional(readOnly = true)
public class SysUserServiceimpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    @Transactional(readOnly = false)
    public void updateSysUser(SysUser sysUser) {
        this.sysUserMapper.updateById(sysUser);
        //添加异常
        throw new TipsRuntimeException(TEST_TRANSACTIONAL);
    }

    @Override
    @DataSource(name = DbEnum.DATA_SOURCE_BIZ)
    public SysUser findSysUserId(Integer id) {
        return sysUserMapper.selectById(id);
    }
}
