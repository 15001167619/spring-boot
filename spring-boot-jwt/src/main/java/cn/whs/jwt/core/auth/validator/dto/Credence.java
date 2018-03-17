package cn.whs.jwt.core.auth.validator.dto;

/**
 * @author 武海升
 * @version 2.0
 * @description
 *      验证的凭据
 * @date 2018-03-17 15:32
 */
public interface Credence {

    /**
     * 凭据名称
     */
    String getCredenceName();

    /**
     * 密码或者是其他的验证码之类的
     */
    String getCredenceCode();
}
