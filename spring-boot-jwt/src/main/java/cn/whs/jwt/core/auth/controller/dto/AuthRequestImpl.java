package cn.whs.jwt.core.auth.controller.dto;

import cn.whs.jwt.core.auth.validator.dto.Credence;

/**
 * @author 武海升
 * @version 2.0
 * @description
 *    认证的请求 实现类
 * @date 2018-03-17 15:46
 */
public class AuthRequestImpl  implements Credence {

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getCredenceName() {
        return this.userName;
    }

    @Override
    public String getCredenceCode() {
        return this.password;
    }
}
