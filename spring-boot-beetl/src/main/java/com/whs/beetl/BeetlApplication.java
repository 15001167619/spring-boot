package com.whs.beetl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-04-25 11:45
 */
@SpringBootApplication
@Slf4j
public class BeetlApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeetlApplication.class, args);
        log.info("BeetlApplication is success!");
    }

}
