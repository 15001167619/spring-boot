package com.whs.mybatis;

import com.whs.mybatis.modules.entity.User;
import com.whs.mybatis.modules.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-05-30 16:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MybatisTest {

    @Autowired
    private IUserService userService;

    @Test
    public void addUser() {
        userService.add(new User("慕小谦",22));
    }

}
