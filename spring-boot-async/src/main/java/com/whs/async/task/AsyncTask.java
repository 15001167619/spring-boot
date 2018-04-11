package com.whs.async.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-04-11 17:07
 */
@Component
@Slf4j
public class AsyncTask {


    @Async
    public void AsyncTaskOne() throws InterruptedException{
        long currentTimeMillis = System.currentTimeMillis();
        log.info("异步 AsyncTaskOne 调用开始" + Thread.currentThread().getName());
        Thread.sleep(3000);
        long currentTimeMillis1 = System.currentTimeMillis();
        log.info("异步 AsyncTaskOne 调用结束" + Thread.currentThread().getName());
        log.info("AsyncTaskOne任务耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms");
    }

    @Async
    public Future<String> AsyncTaskTwo(String  parementer) {
        long currentTimeMillis = System.currentTimeMillis();
        log.info("异步 AsyncTaskTwo 调用开始" + Thread.currentThread().getName());
        log.info("参数：" + parementer);
        Future<String> future;
        try {
            Thread.sleep(5000);
            future = new AsyncResult<>("成功:" +   parementer);
        } catch (InterruptedException e) {
            future = new AsyncResult<>("失败");
        }
        long currentTimeMillis1 = System.currentTimeMillis();
        log.info("异步 AsyncTaskTwo 调用结束" + Thread.currentThread().getName());
        log.info("AsyncTaskTwo任务耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms");
        return future;
    }

    @Async
    public Future<String> AsyncTaskThree(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        log.info("异步 AsyncTaskThree 调用开始" + Thread.currentThread().getName());
        log.info("参数：" + i);
        Future<String> future;
        try {
            Thread.sleep(1000 * i);
            future = new AsyncResult<>("成功:" + i);
        } catch (InterruptedException e) {
            future = new AsyncResult<>("失败");
        }
        long currentTimeMillis1 = System.currentTimeMillis();
        log.info("异步 AsyncTaskThree 调用结束" + Thread.currentThread().getName());
        log.info("AsyncTaskThree任务耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms");
        return future;
    }


}
