package cn.whs.jwt.core.auth.security.impl;

import cn.whs.jwt.core.auth.security.DataSecurityAction;
import org.springframework.util.Base64Utils;

/**
 * @author 武海升
 * @version 2.0
 * @description
 *      进行base64编码的方式
 * @date 2018-03-17 15:07
 */
public class Base64SecurityActionImpl implements DataSecurityAction {
    @Override
    public String doAction(String beProtected) {
        return Base64Utils.encodeToString(beProtected.getBytes());
    }

    @Override
    public String unlock(String securityCode) {
        byte[] bytes = Base64Utils.decodeFromString(securityCode);
        return new String(bytes);
    }
}
