package com.whs.async.controller;

import com.whs.async.task.AsyncTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-04-11 17:25
 */
@RestController
@Slf4j
public class AsyncController {

    @Autowired
    private AsyncTask asyncTask;

    @RequestMapping(value = "asyncTask")
    public String doTask() throws InterruptedException{

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
        return result;
    }


}
