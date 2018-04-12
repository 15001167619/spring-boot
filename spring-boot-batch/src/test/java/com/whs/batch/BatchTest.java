package com.whs.batch;

import com.whs.batch.modules.entity.Person;
import com.whs.batch.modules.service.IPersonService;
import com.whs.batch.utils.CommonUtils;
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
 * @date 2018-04-12 13:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BatchTest {

    @Autowired
    private IPersonService personService;

    @Test
    public void addPerson() {
        personService.insert(new Person(1+(int)(Math.random()*20), CommonUtils.getRandomString(3)));
    }
}
