package com.whs.beetlsql.modules.service;

import com.whs.beetlsql.common.Parameters;
import com.whs.beetlsql.modules.entity.User;

import java.util.List;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-05-23 11:41
 */
public interface IUserService {

    /**
     * 增加用户
     *
     * @param user 用户
     */
    void addUser(User user);

    /**
     * 编辑用户
     *
     * @param user 用户
     */
    void updateUser(User user);

    /**
     * 根据用户名查询用户信息
     *
     * @param userName 用户名
     * @return 用户信息
     */
    User findByName(String userName);

    /**
     * 根据用户Id查询用户信息
     *
     * @param userId 用户Id
     * @return 用户信息
     */
    User findById(Long userId);

    /**
     * 查询用户分页列表
     *
     * @param params 分页参数
     * @return 用户分页列表
     */
    List<User> userPageList(Parameters params);

    /**
     * 根据Id删除用户
     *
     * @param userId 用户id
     */
    void deleteById(Long userId);

}
