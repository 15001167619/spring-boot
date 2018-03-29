package cn.whs.db;

import cn.whs.db.common.CommonUtils;
import cn.whs.db.modules.core.entity.CoreUser;
import cn.whs.db.modules.core.service.ICoreUserService;
import cn.whs.db.modules.one.entity.OneUser;
import cn.whs.db.modules.one.service.IOneUserService;
import cn.whs.db.modules.two.entity.TwoUser;
import cn.whs.db.modules.two.service.ITwoUserService;
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
 * @date 2018-03-28 17:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MultidatasourceTest {

    @Autowired
    private ICoreUserService coreUserService;

    @Autowired
    private IOneUserService oneUserService;

    @Autowired
    private ITwoUserService twoUserService;

    @Test
    public void keyTest() {
        coreUserService.insert(new CoreUser(1+(int)(Math.random()*20),"core"+ CommonUtils.getRandomString(3),CommonUtils.getRandomString(11),CommonUtils.getRandomString(6)));
        oneUserService.insertOneUser(new OneUser(1+(int)(Math.random()*20),"one"+ CommonUtils.getRandomString(3),CommonUtils.getRandomString(11),CommonUtils.getRandomString(6)));
        twoUserService.insertTwoUser(new TwoUser(1+(int)(Math.random()*20),"two"+ CommonUtils.getRandomString(3),CommonUtils.getRandomString(11),CommonUtils.getRandomString(6)));
    }

}
