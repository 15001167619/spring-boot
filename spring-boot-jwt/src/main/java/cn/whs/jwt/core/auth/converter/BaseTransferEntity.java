package cn.whs.jwt.core.auth.converter;

/**
 * @author 武海升
 * @version 2.0
 * @description
 *      基础数据的传输 entity
 * @date 2018-03-17 15:50
 */
public class BaseTransferEntity {

    private String object; //base64编码的json字符串

    private String sign;   //签名

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
