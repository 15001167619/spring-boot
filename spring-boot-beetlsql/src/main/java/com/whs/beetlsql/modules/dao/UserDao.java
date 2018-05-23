package com.whs.beetlsql.modules.dao;

import com.whs.beetlsql.common.Parameters;
import com.whs.beetlsql.modules.entity.User;
import org.beetl.sql.core.annotatoin.SqlStatement;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-05-23 11:39
 */
@Repository
public interface UserDao  extends BaseMapper<User> {

    /**
     * 根据用户名查询用户信息
     *
     * @param userName 用户名
     * @return 用户信息
     */
    @SqlStatement(params = "userName")
    User findByName(String userName);

    /**
     * 根据用户Id查询用户信息
     *
     * @param id 用户Id
     * @return 用户信息
     */
    @SqlStatement(params = "id")
    User findById(Long id);

    /**
     * 查询用户分页列表
     *
     * @param params 分页参数
     * @return 用户分页列表
     */
    @SqlStatement(params = "params")
    List<User> selectPageList(Parameters params);
}
