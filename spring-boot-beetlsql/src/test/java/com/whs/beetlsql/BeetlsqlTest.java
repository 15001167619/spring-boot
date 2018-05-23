package com.whs.beetlsql;

import com.whs.beetlsql.common.Parameters;
import com.whs.beetlsql.modules.entity.User;
import com.whs.beetlsql.modules.service.IUserService;
import com.whs.beetlsql.utils.ToolUtil;
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
 * @date 2018-05-23 12:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BeetlsqlTest {

    @Autowired
    private IUserService userService;

    @Test
    public void testInsertData() {
        User user = new User(ToolUtil.getRandomString(3),ToolUtil.getRandomString(3));
        userService.addUser(user);
        log.info("新增用户ID："+user.getId().toString());
    }
    @Test
    public void testSelectData() {
        User user;
        log.info("********通过用户ID userId 查询用户*********");
        user = userService.findById(1L);
        if(user!=null)log.info("通过用户ID查询用户："+user.toString());
        user = null;
        log.info("********通过用户名 userName 查询用户*********");
        user = userService.findByName("4q8");
        if(user!=null)log.info("通过用户名称查询用户："+user.toString());
        log.info("******** 获取分页List *********");
        userService.userPageList(new Parameters()).stream()
                .forEach(System.out ::println);
    }
    @Test
    public void testUpdateData() {
        userService.updateUser(new User(1L,"userName","mobile"));
    }
    @Test
    public void testDeleteData() {
        userService.deleteById(4L);
    }


}
