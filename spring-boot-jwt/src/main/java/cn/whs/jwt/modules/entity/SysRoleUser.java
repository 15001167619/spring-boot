package cn.whs.jwt.modules.entity;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-16 17:53
 */
public class SysRoleUser {

    private Integer roleId;
    private Integer userId;
    private Integer roleGrade;

    private Integer age;
    private String name;
    private String roleName;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

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
