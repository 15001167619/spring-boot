package cn.whs.jwt;

import cn.whs.jwt.core.redis.IRedisService;
import cn.whs.jwt.modules.entity.SysUser;
import cn.whs.jwt.modules.service.ISysUserService;
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
 * @date 2018-03-21 16:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MySpringBootTest {

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private IRedisService redisService;

    @Test
    public void addUser() {
        sysUserService.insert(new SysUser(20,"name","1234560","000"));
    }

    @Test
    public void keyTest() {
       // boolean b = redisService.addToRedis("name", "武海升", 100L);
       // System.out.println(b);
        String name = redisService.getRedisValueByKey("name");
        log.info("name"+name);
    }
}
