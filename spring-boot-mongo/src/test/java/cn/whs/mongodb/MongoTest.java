package cn.whs.mongodb;

import cn.whs.mongodb.entity.OperationLog;
import cn.whs.mongodb.service.IOperationLogService;
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
public class MongoTest {

    @Autowired
    private IOperationLogService operationLogService;

    @Test
    public void insertTest() {
        for (int i = 0; i < 20; i++) {
            //默认增加（通过实体类）
            operationLogService.insert(new OperationLog("LogType_"+i,"LogName_"+i),null);
            //指定结合名称增加
            operationLogService.insert(new OperationLog("logType_"+i,"logName_"+i),"operationLogTest");
        }
    }

    @Test//默认删除（通过实体类）
    public void delTest() {
        OperationLog operationLog = new OperationLog();
        operationLog.setLogName("LogName_0");
        //通过条件删除
        operationLogService.delBatch(operationLog,null);
        //通过id删除
        operationLogService.delById(new OperationLog(),"5ac9cdea110b471a4cfc275b",null);
    }

    @Test//通过指定集合名称删除
    public void delForNameTest() {
        OperationLog operationLog = new OperationLog();
        operationLog.setLogType("logType_19");
        //通过条件删除
        operationLogService.delBatch(operationLog,"operationLogTest");
        //通过id删除
        operationLogService.delById(new OperationLog(),"5ac9cdea110b471a4cfc275a","operationLogTest");
    }

    @Test
    public void updateTest() {
        OperationLog operationLog1 = new OperationLog();
        operationLog1.setLogType("好好学习");
        operationLog1.setLogName("天天向上");
        operationLog1.setId("5ac9cdea110b471a4cfc27370");
        boolean update = operationLogService.update(operationLog1, null);
       /* OperationLog operationLog = operationLogService.findById(new OperationLog(), "5ac9cdea110b471a4cfc27370", null);
        if(operationLog!=null){
            operationLog.setLogType("好好学习");
            operationLog.setLogName("天天向上");
            operationLogService.update(operationLog,null);
        }*/

    }





}
