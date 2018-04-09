package cn.whs.mongodb;

import cn.whs.mongodb.entity.OperationLog;
import cn.whs.mongodb.service.IOperationLogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
            //指定集合名称增加
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
        operationLogService.delById(new OperationLog(),"5acabfad110b4709f869c8f1",null);
    }

    @Test//通过指定集合名称删除
    public void delForNameTest() {
        OperationLog operationLog = new OperationLog();
        operationLog.setLogType("logType_19");
        //通过条件删除
        operationLogService.delBatch(operationLog,"operationLogTest");
        //通过id删除
        operationLogService.delById(new OperationLog(),"5acabfad110b4709f869c914","operationLogTest");
    }

    @Test//默认更新（通过实体类）
    public void updateTest() {
        OperationLog operationLog = operationLogService.findById(new OperationLog(), "5acac603110b47205cdb6e04",null );
        System.out.println(operationLog);
        System.out.println(operationLog.getId());
        operationLog.setLogType("好好学习1..");
        System.out.println(operationLogService.update(operationLog,null));
    }

    @Test//指定更新（通过集合名称）
    public void updateForNameTest() {
        OperationLog operationLog = operationLogService.findById(new OperationLog(), "5ac9cdea110b471a4cfc2736", "operationLogTest");
        System.out.println(operationLog);
        operationLog.setLogName("天天向上..");
        System.out.println(operationLogService.update(operationLog, "operationLogTest"));
    }

    @Test
    public void findListTest() {

        //默认实体类对应集合查询
        List<OperationLog> list = operationLogService.findList(new OperationLog(), null);
        list.forEach(System.out :: println);

        //指定条件、集合名称查询
        System.out.println("*********指定条件、集合名称查询**********");
        OperationLog operationLog = new OperationLog();
        operationLog.setLogType("logType_0");
        List<OperationLog> operationLogTestList = operationLogService.findList(operationLog, "operationLogTest");
        operationLogTestList.forEach(System.out :: println);
    }







}
