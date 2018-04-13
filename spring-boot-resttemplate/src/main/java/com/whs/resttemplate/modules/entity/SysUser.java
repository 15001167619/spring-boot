package com.whs.resttemplate.modules.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.whs.resttemplate.utils.CommonUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Map;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-15 21:35
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class SysUser extends Model {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer age;
    private String name;
    private String mobile;
    private String password;
    private String salt;


    public SysUser(Integer id) {
        this.id = id;
    }
    public SysUser() {
    }
    public SysUser(Integer age,String name) {
        this.age = age;
        this.name = name;
    }
    public SysUser(Integer age,String name,String mobile,String password) {
        this.age = age;
        this.name = name;
        this.mobile = mobile;
        this.password = password;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static SysUser mapToSysUser(Map<String, Object> map, Class<?> beanClass){
        try {
            return (SysUser) CommonUtils.mapToObject(map, beanClass);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
