package cn.whs.db.core.mysql.config;

import cn.whs.db.core.mysql.DataSourceName;
import cn.whs.db.core.mysql.DynamicDataSource;
import cn.whs.db.core.mysql.properties.DruidProperties;
import cn.whs.db.core.mysql.properties.MultipleMysqlProperties;
import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-28 13:43
 */
@Configuration
@EnableTransactionManagement(order = 2)//由于引入多数据源，所以让spring事务的aop要在多数据源切换aop的后面
@MapperScan(basePackages = {"cn.whs.db.modules.dao"})
public class MultipleMysqlConfig {

    @Autowired
    private DruidProperties druidProperties;
    @Autowired
    private MultipleMysqlProperties multipleMysqlProperties;

    /**
     * 核心数据源
     */
    private DruidDataSource coreDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        return dataSource;
    }

    /**
     * 其它数据源（一）
     */
    private DruidDataSource dataSourceBizOne() {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        multipleMysqlProperties.getDataSourceBizOne().config(dataSource);
        return dataSource;
    }

    /**
     * 其它数据源(二)
     */
    private DruidDataSource dataSourceBizTwo() {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        multipleMysqlProperties.getDataSourceBizTwo().config(dataSource);
        return dataSource;
    }

    /**
     * 单数据源连接池配置
     */
    @Bean
    @ConditionalOnProperty(prefix = "dynamicSwitch", name = "multi-datasource-open", havingValue = "false")
    public DruidDataSource singleDatasource() {
        return coreDataSource();
    }

    /**
     * 多数据源连接池配置
     */
    @Bean
    @ConditionalOnProperty(prefix = "dynamicSwitch", name = "multi-datasource-open", havingValue = "true")
    public DynamicDataSource multiDataSource() {

        DruidDataSource coreDataSource = coreDataSource();
        DruidDataSource dataSourceBizOne = dataSourceBizOne();
        DruidDataSource dataSourceBizTwo = dataSourceBizTwo();

        try {
            coreDataSource.init();
            dataSourceBizOne.init();
            dataSourceBizTwo.init();
        } catch (SQLException sql) {
            sql.printStackTrace();
        }

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put(DataSourceName.DATA_SOURCE_CORE, coreDataSource);
        hashMap.put(DataSourceName.DATA_SOURCE_BIZ_ONE, dataSourceBizOne);
        hashMap.put(DataSourceName.DATA_SOURCE_BIZ_TWO, dataSourceBizTwo);
        dynamicDataSource.setTargetDataSources(hashMap);
        dynamicDataSource.setDefaultTargetDataSource(coreDataSource);
        return dynamicDataSource;
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
