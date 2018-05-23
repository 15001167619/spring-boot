package com.whs.beetlsql;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-05-22 9:24
 */
@SpringBootApplication
@Slf4j
public class BeetlsqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeetlsqlApplication.class,args);
        log.info("BeetlsqlApplication is success!");
    }

}
