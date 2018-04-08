package cn.whs.mongodb.core;

import com.cybermkd.mongo.kit.MongoKit;
import com.cybermkd.mongo.plugin.MongoJFinalPlugin;
import com.mongodb.*;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-04-08 10:59
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring.data")
public class MongoPluginProperties {

    private MongoClientOptions.Builder options = MongoClientOptions.builder();
    private List<ServerAddress> hostList = new ArrayList();
    private List<MongoCredential> authList = new ArrayList();
    private String host;
    private int port;
    private String database;
    private String username;
    private String password;

    public MongoPluginProperties() {
    }

    public MongoPluginProperties add(String host) {
        this.hostList.add(new ServerAddress(host, 27017));
        return this;
    }

    public MongoPluginProperties add(String host, int port) {
        this.hostList.add(new ServerAddress(host, port));
        return this;
    }

    public MongoPluginProperties setDatabase(String database) {
        this.database = database;
        return this;
    }

    public String getDatabase() {
        return this.database;
    }

    public MongoPluginProperties auth(MongoCredential mongoCredential) {
        this.authList.add(mongoCredential);
        return this;
    }

    public MongoPluginProperties auth(String username, String password) {
        this.authList.add(MongoCredential.createScramSha1Credential(username, this.database, password.toCharArray()));
        return this;
    }

    public MongoPluginProperties authCR(String username, String password) {
        this.authList.add(MongoCredential.createMongoCRCredential(username, this.database, password.toCharArray()));
        return this;
    }

    public MongoPluginProperties authX509(String x509) {
        this.authList.add(MongoCredential.createMongoX509Credential(x509));
        return this;
    }

    public MongoPluginProperties ssl() {
        this.options.sslEnabled(true);
        return this;
    }

    public MongoPluginProperties connectTimeout(int connectTimeout) {
        this.options.connectTimeout(connectTimeout);
        return this;
    }

    public MongoPluginProperties opition(MongoClientOptions.Builder opitions) {
        this.options = opitions;
        return this;
    }

    public MongoPluginProperties readPreference(ReadPreference readPreference) {
        this.options.readPreference(readPreference);
        return this;
    }

    public MongoPluginProperties readPreference() {
        this.options.readPreference(ReadPreference.secondaryPreferred());
        return this;
    }

    public MongoPluginProperties writeConcern(WriteConcern writeConcern) {
        this.options.writeConcern(writeConcern);
        return this;
    }

    public MongoPluginProperties writeConcern() {
        this.options.writeConcern(WriteConcern.JOURNALED);
        return this;
    }

    public MongoPluginProperties writeSafe() {
        this.options.writeConcern(WriteConcern.MAJORITY);
        return this;
    }

    public MongoPluginProperties setDebug(boolean debug) {
        MongoKit.INSTANCE.setDebug(debug);
        return this;
    }

    public MongoClient getMongoClient() {
        try {
            return new MongoClient(this.hostList, this.authList, this.options.build());
        } catch (Exception var2) {
            throw new RuntimeException("无法连接mongodb,请检查配置!Can\'t connect mongodb!");
        }
    }

    public void config(MongoJFinalPlugin jFinalPlugin) {
        jFinalPlugin.add(host, port);
        jFinalPlugin.setDatabase(database);
        jFinalPlugin.auth(username, password);
    }
}
