package cn.whs.jwt.modules.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-16 17:53
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class SysRoleUser {

    private Integer roleId;
    private Integer userId;
    private Integer roleGrade;

    private Integer age;
    private String name;
    private String roleName;
}
