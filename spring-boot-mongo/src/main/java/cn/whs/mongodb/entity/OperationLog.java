package cn.whs.mongodb.entity;

import cn.whs.mongodb.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-23 16:28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OperationLog extends BaseEntity{

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
