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
     * 用于客户端混淆md5加密
     */
    private final String randomKey;

    public AuthResponseImpl(String token, String randomKey) {
        this.token = token;
        this.randomKey = randomKey;
    }

    public String getToken() {
        return this.token;
    }

    public String getRandomKey() {
        return randomKey;
    }

}
