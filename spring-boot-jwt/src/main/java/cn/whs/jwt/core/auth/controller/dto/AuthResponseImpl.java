package cn.whs.jwt.core.auth.controller.dto;

import java.io.Serializable;

/**
 * @author 武海升
 * @version 2.0
 * @description
 *      返回体
 *      认证的响应结果
 * @date 2018-03-17 15:48
 */
public class AuthResponseImpl implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    /**
     * jwt token
     */
    private final String token;

    /**
     * 签名
     */
    private final String sign;

    public AuthResponseImpl(String token, String sign) {
        this.token = token;
        this.sign = sign;
    }

    public String getToken() {
        return this.token;
    }

    public String getSign() {
        return sign;
    }

}
