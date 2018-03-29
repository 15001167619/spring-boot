package cn.whs.db;

import cn.whs.db.common.CommonUtils;
import cn.whs.db.modules.entity.CoreUser;
import cn.whs.db.modules.mongo.entity.OperationLog;
import cn.whs.db.modules.mongo.service.IOperationLogService;
import cn.whs.db.modules.service.ICoreUserService;
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
public class MultidatasourceTest {

    @Autowired
    private ICoreUserService coreUserService;

    @Autowired
    private IOperationLogService operationLogService;


    @Test
    public void insertTest() {
        coreUserService.insert(new CoreUser(1+(int)(Math.random()*20),"core"+ CommonUtils.getRandomString(3),CommonUtils.getRandomString(11),CommonUtils.getRandomString(6)));
        coreUserService.insertOneUser(new CoreUser(1+(int)(Math.random()*20),"core"+ CommonUtils.getRandomString(3),CommonUtils.getRandomString(11),CommonUtils.getRandomString(6)));
        coreUserService.insertTwoUser(new CoreUser(1+(int)(Math.random()*20),"core"+ CommonUtils.getRandomString(3),CommonUtils.getRandomString(11),CommonUtils.getRandomString(6)));
        operationLogService.saveOperationLog(new OperationLog());
    }
}
