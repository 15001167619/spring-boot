package cn.whs.jwt;

import cn.whs.jwt.mongo.entity.OperationLog;
import cn.whs.jwt.mongo.service.IOperationLogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-23 16:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMongoDbTest {

    @Autowired
    private IOperationLogService operationLogService;

    @Test
    public void saveOperationLog() throws Exception {
        operationLogService.saveOperationLog(new OperationLog());
    }
    @Test
    public void deleteOperationLogByUserId() throws Exception {
        operationLogService.deleteOperationLogByUserId(10000);
    }

}
