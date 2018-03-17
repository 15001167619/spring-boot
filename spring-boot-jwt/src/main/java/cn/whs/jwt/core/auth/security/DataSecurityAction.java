package cn.whs.jwt.core.auth.security;

/**
 * @author 武海升
 * @version 2.0
 * @description
 *      数据传递的保护措施
 *      编写自己的数据加密方案,只需实现此类,并在WebConfig下配置编写的实现类即可
 * @date 2018-03-17 15:04
 */
public interface DataSecurityAction {

    /**
     * 执行数据的保护措施
     */
    String doAction(String beProtected);

    /**
     * 解除保护
     */
    String unlock(String securityCode);
}
