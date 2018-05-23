package com.whs.beetlsql.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * @author 武海升
 * @version 2.0
 * @description 数据库数据源配置
 * @date 2018-03-15 14:26
 */
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


    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public Integer getInitialSize() {
        return initialSize;
    }

    public void setInitialSize(Integer initialSize) {
        this.initialSize = initialSize;
    }

    public Integer getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(Integer minIdle) {
        this.minIdle = minIdle;
    }

    public Integer getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(Integer maxActive) {
        this.maxActive = maxActive;
    }
}