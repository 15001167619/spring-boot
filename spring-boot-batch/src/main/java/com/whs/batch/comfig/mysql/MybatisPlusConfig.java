package com.whs.batch.comfig.mysql;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.whs.batch.comfig.mysql.properties.DruidProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-15 14:52
 */
@Configuration
@EnableTransactionManagement(order = 2)
@MapperScan(basePackages = {"com.whs.batch.modules.dao"})
public class MybatisPlusConfig {

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

    /**
     * mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }
}
