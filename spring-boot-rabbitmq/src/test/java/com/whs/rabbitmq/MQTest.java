package com.whs.rabbitmq;

import com.whs.rabbitmq.service.ISenderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-04-13 10:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MQTest {

    @Autowired
    private ISenderService senderService;

    @Test
    public void testCache() {
        // 测试广播模式
        senderService.broadcast("同学们集合啦！");
        // 测试Direct模式
        senderService.direct("定点消息");
    }
}
