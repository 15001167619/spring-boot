package com.whs.mybatis.modules.service.impl;

import com.whs.mybatis.modules.dao.UserDao;
import com.whs.mybatis.modules.entity.User;
import com.whs.mybatis.modules.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-05-30 15:58
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    public int add(User user) {
        return userDao.insertUser(user);
    }
}
