package cn.whs.jwt.modules.service;

import cn.whs.jwt.modules.entity.SysRoleUser;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-16 21:22
 */
public interface ISysRoleUserService  extends IService<SysRoleUser> {

    Page<SysRoleUser> selectSysRoleUserPage(Page<SysRoleUser> page, @Param("ew") Wrapper<SysRoleUser> wrapper);
}
