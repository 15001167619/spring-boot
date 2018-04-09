package cn.whs.mongodb.base;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-04-09 9:18
 */
@Data
public class BaseEntity {

    @JSONField(name = "_id")
    private String id;



}
