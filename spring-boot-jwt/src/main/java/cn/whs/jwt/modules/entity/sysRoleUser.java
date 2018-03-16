package cn.whs.jwt.modules.entity;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-16 17:53
 */
public class sysRoleUser {

    private Integer roleId;
    private Integer userId;
    private Integer roleGrade;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleGrade() {
        return roleGrade;
    }

    public void setRoleGrade(Integer roleGrade) {
        this.roleGrade = roleGrade;
    }


}
