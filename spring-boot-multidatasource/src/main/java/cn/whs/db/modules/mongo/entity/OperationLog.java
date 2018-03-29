package cn.whs.db.modules.mongo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-23 16:28
 */
@Data
public class OperationLog {
    private String logType = "登录日志";
    private String logName = "用户登录操作";
    private Integer userId = 10000;
    private String classname;
    private String method ;
    private Long createTime = new Date().getTime();
    private String succeed;
    private String message;
}
