package com.whs.beetlsql.modules.service.impl;

import com.whs.beetlsql.modules.dao.UserDao;
import com.whs.beetlsql.modules.entity.User;
import com.whs.beetlsql.modules.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-05-23 11:42
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.insert(user, true);//可获取刚插入的id
    }

    @Override
    public void updateUser(User user) {
        userDao.updateById(user);
    }

    @Override
    public User findByName(String userName) {
        User user = userDao.findByName(userName);
        return user==null?null:user;
    }

    @Override
    public User findById(Long id) {
        User user = userDao.findById(id);
        return user==null?null:user;
    }

    @Override
    public void deleteById(Long userId) {
        userDao.deleteById(userId);
    }
}
