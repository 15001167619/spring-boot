package com.whs.starter.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-06-12 9:58
 */
@Data
@ConfigurationProperties(prefix = "log")
public class LogProperties {

    private String exclude;

    private String[] excludeArr;

    @PostConstruct// @PostConstruct 是spring注解，在方法上加该注解会在项目启动的时候执行该方法，即在spring容器初始化的时候执行该方法。
    public void init() {
        this.excludeArr = StringUtils.split(exclude, ",");
    }

}
