package cn.whs.mongodb.core.config;

import cn.whs.mongodb.core.MongoPluginProperties;
import com.cybermkd.mongo.plugin.MongoJFinalPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-04-08 11:07
 */
@Configuration
public class MongoPluginConfig {

    @Resource
    private MongoPluginProperties mongoPluginProperties;

    @Bean
    public MongoJFinalPlugin initMongoDatasource() {
        MongoJFinalPlugin jFinalPlugin = new MongoJFinalPlugin();
        mongoPluginProperties.config(jFinalPlugin);
        jFinalPlugin.start();
        return jFinalPlugin;
    }

}
