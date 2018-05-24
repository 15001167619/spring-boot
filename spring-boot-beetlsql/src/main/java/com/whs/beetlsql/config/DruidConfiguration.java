package com.whs.beetlsql.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.whs.beetlsql.config.properties.DruidProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-05-23 11:10
 */
@Configuration
public class DruidConfiguration {

    @Resource
    private DruidProperties druidProperty;

    @Bean(name = "datasource")//数据库配置bean
    public DataSource getDataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(druidProperty.getDriverClassName());
        dataSource.setUrl(druidProperty.getUrl());
        dataSource.setUsername(druidProperty.getUsername());
        dataSource.setPassword(druidProperty.getPassword());
        dataSource.setFilters(druidProperty.getFilter());
        dataSource.setInitialSize(druidProperty.getInitialSize());
        dataSource.setMinIdle(druidProperty.getMinIdle());
        dataSource.setMaxActive(druidProperty.getMaxActive());
        return dataSource;
    }
}
