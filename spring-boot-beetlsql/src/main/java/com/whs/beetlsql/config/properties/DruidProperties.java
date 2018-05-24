package com.whs.beetlsql.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * @author 武海升
 * @version 2.0
 * @description 数据库数据源配置
 * @date 2018-03-15 14:26
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class DruidProperties {

    private String driverClassName;//连接驱动
    private String url;//url地址
    private String username;//用户名
    private String password;//密码
    private String filter;//filter过滤
    private Integer initialSize;//初始化连接大小
    private Integer minIdle;//最小空闲连接数
    private Integer maxActive;//最大连接数

}