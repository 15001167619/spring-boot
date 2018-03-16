package cn.whs.jwt.modules.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-16 17:49
 */
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    protected Serializable pkVal() {
        return null;
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
