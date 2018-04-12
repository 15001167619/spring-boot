package com.whs.batch.modules.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-04-12 11:37
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class Person extends Model {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer age;
    private String name;

    public Person() {
    }

    public Person(Integer age,String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
