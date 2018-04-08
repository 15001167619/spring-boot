package cn.whs.mongodb.base;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-04-04 13:54
 */
@Data
public class MongoEntityBase {

    private String id;

    @JSONField(name = "_id")
    public String getId() {
        return id;
    }

}
