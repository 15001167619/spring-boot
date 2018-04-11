package com.whs.async;

import com.whs.async.task.AsyncTask;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-04-11 17:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AsyncTest {

    @Autowired
    private AsyncTask asyncTask;

    @Test
    public void testAsync() throws InterruptedException, ExecutionException {
        long currentTimeMillis = System.currentTimeMillis();

        asyncTask.AsyncTaskOne();

        Future<String> taskFutureTwo = asyncTask.AsyncTaskTwo("执行异步方法");
        Future<String> taskFutureThree = asyncTask.AsyncTaskThree(10);
        String result;
        for (;;) {
            if(taskFutureTwo.isDone() && taskFutureThree.isDone()) {
                break;
            }
            Thread.sleep(1000);
        }
        long currentTimeMillis1 = System.currentTimeMillis();
        result = "AsyncTask 任务总耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms";
        log.info(result);
    }

}
