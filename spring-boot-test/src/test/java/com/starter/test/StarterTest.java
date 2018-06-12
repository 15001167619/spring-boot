package com.starter.test;

import com.starter.test.service.LogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-06-11 14:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StarterTest {

    @Autowired
    private LogService logService;

    @Test
    public void logTest() {
        logService.core(1);
        logService.test(666,"慕小谦");
        logService.work(1);
    }

}
