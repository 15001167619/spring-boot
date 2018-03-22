package cn.whs.jwt;

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
 * @date 2018-03-22 17:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MutiDataSourceSpringBootTest {

    @Autowired
    private ISysUserService sysUserService;

    //多数据源测试
    @Test
    public void findSysUser() {
        SysUser sysUser = sysUserService.findSysUserId(2);
        log.info(sysUser.toString());
    }
}
