package cn.whs.mongodb.base.service;

import java.util.List;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-04-08 13:25
 */
public interface IService<T> {

    boolean insert(T t,String collectionName);

    long delBatch(T t,String collectionName);

    boolean delById(T t,String id,String collectionName);

    boolean update(String id,T t,String collectionName);

    List<T> findList(T t,String collectionName);

    T findById(T t,String id,String collectionName);

}
