package cn.whs.db.modules.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-28 15:58
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class CoreUser  extends Model {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer age;
    private String name;
    private String mobile;
    private String password;
    private LocalDateTime insertTime;

    public CoreUser(){}

    public CoreUser(Integer age,String name,String mobile,String password) {
        this.age = age;
        this.name = name;
        this.mobile = mobile;
        this.password = password;
        this.insertTime = LocalDateTime.now();
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
