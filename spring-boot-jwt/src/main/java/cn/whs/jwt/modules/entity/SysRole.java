package cn.whs.jwt.modules.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-16 17:49
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class SysRole  extends Model {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String roleName;
    private String createUserId;
    private Date createDate = new Date();
    private Date updateDate = new Date();
    private String updateUserId;
    private String remarks;
    private Integer delFlag;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", createUserId='" + createUserId + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", updateUserId='" + updateUserId + '\'' +
                ", remarks='" + remarks + '\'' +
                ", delFlag=" + delFlag +
                '}';
    }
}
