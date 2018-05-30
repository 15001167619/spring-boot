package com.whs.mybatis.modules.dao;

import com.whs.mybatis.modules.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-05-30 15:46
 */
@Mapper
public interface  UserDao {

    /**
     * 插入用户
     * @param user
     * @return
     */
    int insertUser(@Param("user") User user);

}
