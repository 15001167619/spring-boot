package cn.whs.jwt.modules.dao;

import cn.whs.jwt.modules.entity.SysRoleUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-16 21:24
 */
public interface SysRoleUserMapper extends BaseMapper<SysRoleUser> {

    //@Select("selectRoleUserPage")
    List<SysRoleUser> findSysRoleUserList(Pagination page, @Param("ew") Wrapper<SysRoleUser> wrapper);





}
