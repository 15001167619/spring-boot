package com.whs.validcode;

import com.whs.validcode.common.utils.ToolUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-05-07 10:49
 */
@SpringBootApplication
@Slf4j
public class ValidCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ValidCodeApplication.class, args);
        log.info("ValidCodeApplication is success! ===> Start Time "+ ToolUtil.getNowTime());
    }

}
