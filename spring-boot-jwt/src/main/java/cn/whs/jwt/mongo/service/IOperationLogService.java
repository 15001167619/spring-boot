package cn.whs.jwt.mongo.service;

import cn.whs.jwt.mongo.entity.OperationLog;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-23 16:30
 */
public interface IOperationLogService {

    void saveOperationLog(OperationLog operationLog);

    OperationLog findUserByLogName(String logName);

    void deleteOperationLogByUserId(Integer userId);
}
