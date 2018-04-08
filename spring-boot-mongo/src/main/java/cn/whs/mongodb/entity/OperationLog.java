package cn.whs.mongodb.entity;

import cn.whs.mongodb.base.MongoEntityBase;
import lombok.Data;

import java.time.Instant;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-23 16:28
 */
@Data
public class OperationLog extends MongoEntityBase {

    private String logType;
    private String logName;
    private Long createTime;

    public OperationLog() {
    }

    public OperationLog(String logType,String logName) {
        this.logType = logType;
        this.logName = logName;
        this.createTime = Instant.now().toEpochMilli();
    }
}
