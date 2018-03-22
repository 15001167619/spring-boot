package cn.whs.jwt.modules.dao;

import cn.whs.jwt.modules.entity.SysUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-15 21:37
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 通过手机号获取用户
     */
    SysUser getByMobile(@Param("mobile") String mobile);
}
