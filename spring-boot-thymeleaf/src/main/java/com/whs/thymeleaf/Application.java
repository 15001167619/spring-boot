package com.whs.thymeleaf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-04-17 9:22
 */
@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
        log.info("Application  Spring Boot Thymeleaf start-up is success!");
    }


}
