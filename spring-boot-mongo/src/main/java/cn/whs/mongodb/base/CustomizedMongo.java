package cn.whs.mongodb.base;

import cn.whs.mongodb.common.utils.CommonUtils;
import com.cybermkd.mongo.kit.MongoQuery;
import net.vidageek.mirror.dsl.Mirror;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-04-04 13:39
 */
public class CustomizedMongo<T> {

    private MongoQuery mongoQuery;

    private Class aClass;

    public CustomizedMongo(Class aClass) {
        this.aClass = aClass;
    }

    public MongoQuery getMongoQuery(T obj) {
        mongoQuery = new MongoQuery().use(aClass.getSimpleName());
        return initMongoQuery(mongoQuery, obj);
    }

    private MongoQuery initMongoQuery(MongoQuery mongoQuery,T obj){
        List<Field> fs = new Mirror().on(obj.getClass()).reflectAll().fields();
        for (Field field : fs) {
            if (field.getModifiers() != 2) {
                continue;
            }
            Object value = new Mirror().on(obj).get().field(field);
            if (value == null) {
                continue;
            }
            mongoQuery.eq(field.getName(), value);
        }
        return mongoQuery;
    }

    public MongoQuery getMongoQuery(T obj,String collectionName) {
        mongoQuery = new MongoQuery().use(collectionName);
        return initMongoQuery(mongoQuery, obj);
    }

    public boolean save(T obj,String collectionName) {
        if(CommonUtils.isBlank(collectionName)){
            mongoQuery = new MongoQuery().use(aClass.getSimpleName());
        }else mongoQuery = new MongoQuery().use(collectionName);
        return mongoQuery.set(obj).save();
    }

    public boolean del(String id,String collectionName) {
        if(CommonUtils.isBlank(collectionName)){
            mongoQuery = new MongoQuery().use(aClass.getSimpleName());
        }else mongoQuery = new MongoQuery().use(collectionName);
        return mongoQuery.byId(id).deleteOne();
    }

    public long del(T obj,String collectionName) {
        if(CommonUtils.isBlank(collectionName)){
            mongoQuery = this.getMongoQuery(obj);
        }else mongoQuery = this.getMongoQuery(obj,collectionName);
        return mongoQuery.delete();
    }



    public boolean update(T obj) {
        mongoQuery = new MongoQuery().use(aClass.getSimpleName());
        String id = ((MongoEntityBase)obj).getId();
        if (mongoQuery.byId(id).replace(obj) > 0) {
            return true;
        }
        return false;
    }
    public long update(T exist,T replaceBean) {
        return this.getMongoQuery(exist).replace(replaceBean);
    }

    public boolean updateById(T obj,String collectionName) {
        if(CommonUtils.isBlank(collectionName)){
            mongoQuery = new MongoQuery().use(aClass.getSimpleName());
        }else mongoQuery = new MongoQuery().use(collectionName);

        String id = ((MongoEntityBase) obj).getId();
        if (mongoQuery.byId(id).replace(obj) > 0) {
            return true;
        }
        return false;
    }

    public T findById(String id,String collectionName) {
        if(CommonUtils.isBlank(collectionName)){
            mongoQuery = new MongoQuery().use(aClass.getSimpleName());
        }else mongoQuery = new MongoQuery().use(collectionName);
        return (T) mongoQuery.byId(id).findOne(aClass);
    }

    public T findOne(T obj) {
        mongoQuery = this.getMongoQuery(obj);// 匹配查询条件
        return (T) mongoQuery.findOne(aClass);
    }

    public List<T> findAll() {
        mongoQuery = new MongoQuery().use(aClass.getSimpleName());
        return mongoQuery.findAll(aClass);
    }

    /**
     * 查询数据库
     *
     * @param obj
     */
    public List<T> find(T obj) {
        mongoQuery = this.getMongoQuery(obj);//匹配查询条件
        List<T> list = mongoQuery.find(aClass);
        return list;
    }


}
