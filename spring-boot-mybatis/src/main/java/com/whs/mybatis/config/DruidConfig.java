package com.whs.mybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.whs.mybatis.config.properties.DruidProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-05-30 15:50
 */
@Configuration
@MapperScan(basePackages = {"com.whs.mybatis.modules.dao"})
public class DruidConfig {

    @Resource
    private DruidProperties druidProperties;

    /**
     * 核心数据源
     */
    private DruidDataSource coreDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        return dataSource;
    }


    /**
     * 单数据源连接池配置
     */
    @Bean
    public DruidDataSource singleDatasource() {
        return coreDataSource();
    }

}
