package cn.whs.jwt.modules.service.impl;

import cn.whs.jwt.modules.dao.SysRoleUserMapper;
import cn.whs.jwt.modules.entity.SysRoleUser;
import cn.whs.jwt.modules.service.ISysRoleUserService;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-16 21:22
 */
@Service
public class SysRoleUserServiceimpl extends ServiceImpl<SysRoleUserMapper, SysRoleUser> implements ISysRoleUserService {

    @Autowired
    private SysRoleUserMapper sysRoleUserMapper;

    @Override
    public Page<SysRoleUser> selectSysRoleUserPage(Page<SysRoleUser> page, @Param("ew") Wrapper<SysRoleUser> wrapper) {
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题
        // page.setOptimizeCountSql(false);
        // 不查询总记录数
        // page.setSearchCount(false);
        return page.setRecords(sysRoleUserMapper.findSysRoleUserList(page, wrapper));
    }
}
