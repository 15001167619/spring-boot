package cn.whs.db.modules.mongo.service;


import cn.whs.db.modules.mongo.entity.OperationLog;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-23 16:30
 */
public interface IOperationLogService {

    void saveOperationLog(OperationLog operationLog);


    void deleteOperationLogByUserId(Integer userId);
}
