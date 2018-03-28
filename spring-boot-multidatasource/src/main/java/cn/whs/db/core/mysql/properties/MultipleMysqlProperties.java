package cn.whs.db.core.mysql.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-28 13:33
 */
@Data
@ConfigurationProperties(prefix = "multi-datasource")
@Component
public class MultipleMysqlProperties {

    private DruidProperties dataSourceBizOne = new DruidProperties();
    private DruidProperties dataSourceBizTwo = new DruidProperties();

}
