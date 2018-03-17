package cn.whs.jwt.core.auth.validator;

import cn.whs.jwt.core.auth.validator.dto.Credence;

/**
 * @author 武海升
 * @version 2.0
 * @description
 *      <p>校验请求/auth接口时,请求参数的正确性</p>
 *      <p>如果想拓展验证方法只需实现这个接口
 *      在AuthenticationRestController类中注意相应实现的本接口的类即可</p>
 * @date 2018-03-17 15:30
 */
public interface IReqValidator {

    /**
     * 通过请求参数验证
     */
    boolean validate(Credence credence);

}
