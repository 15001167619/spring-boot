package cn.whs.mongodb.base.service.impl;

import cn.whs.mongodb.base.CustomizedMongo;
import cn.whs.mongodb.base.service.IService;

import java.util.List;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-04-08 13:30
 */
public class ServiceImpl<T> implements IService<T> {

    @Override
    public boolean insert(T t, String collectionName) {
        return new CustomizedMongo<T>(t.getClass()).save(t,collectionName);
    }

    @Override
    public long delBatch(T t,String collectionName) {
        return new CustomizedMongo<T>(t.getClass()).del(t,collectionName);
    }

    @Override
    public boolean delById(T t, String id, String collectionName) {
        return new CustomizedMongo<T>(t.getClass()).del(id,collectionName);
    }

    @Override
    public boolean update(String id,T t, String collectionName) {
        return new CustomizedMongo<T>(t.getClass()).updateById(id,t,collectionName);
    }

    @Override
    public List<T> findList(T t,String collectionName) {
        return null;
    }

    @Override
    public T findById(T t, String id,String collectionName) {
        return new CustomizedMongo<T>(t.getClass()).findById(id,collectionName);
    }
}
