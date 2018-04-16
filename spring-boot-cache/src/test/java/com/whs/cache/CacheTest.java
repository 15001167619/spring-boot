package com.whs.cache;

import com.whs.cache.modules.entity.SysUser;
import com.whs.cache.modules.service.ISysUserService;
import com.whs.cache.utils.CommonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-04-16 9:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheTest {

    @Autowired
    private ISysUserService sysUserService;

    @Test
    public void insertTest() {
        SysUser sysUser = new SysUser(1+(int)(Math.random()*20),"cache"+ CommonUtils.getRandomString(3),CommonUtils.getRandomString(11),CommonUtils.getRandomString(6));
        sysUserService.insert(sysUser);
    }


}
