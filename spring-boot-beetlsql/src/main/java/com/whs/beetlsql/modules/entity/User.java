package com.whs.beetlsql.modules.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.beetl.sql.core.TailBean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-05-23 11:36
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class User  extends TailBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String mobile;
    private String userName;
    private Date createTime = new Date();

    public User(Long userId,String userName,String mobile){
        this.id = userId;
        this.userName = userName;
        this.mobile = mobile;
    }
    public User(String userName,String mobile){
        this.userName = userName;
        this.mobile = mobile;
    }
    public User(){
    }

}
