package cn.whs.jwt.mongo.service.impl;

import cn.whs.jwt.mongo.entity.OperationLog;
import cn.whs.jwt.mongo.service.IOperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-23 16:31
 */
@Service
public class OperationLogServiceImpl implements IOperationLogService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveOperationLog(OperationLog operationLog) {
        mongoTemplate.save(operationLog);
    }

    @Override
    public OperationLog findUserByLogName(String logName) {
        Query query=new Query(Criteria.where("logName").is(logName));
        return mongoTemplate.findOne(query , OperationLog.class);
    }


    @Override
    public void deleteOperationLogByUserId(Integer userId) {
        Query query=new Query(Criteria.where("userId").is(userId));
        mongoTemplate.remove(query,OperationLog.class);
    }
}
