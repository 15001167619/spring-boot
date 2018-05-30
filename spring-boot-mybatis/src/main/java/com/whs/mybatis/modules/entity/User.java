package com.whs.mybatis.modules.entity;

import lombok.Data;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-05-30 15:45
 */
@Data
public class User {

    private String name;
    private Integer age;

    public User(String name,Integer age){
        this.name = name;
        this.age = age;
    }
    public User(){

    }



}
