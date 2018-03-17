package cn.whs.jwt.core.auth.validator.impl;

import cn.whs.jwt.core.auth.validator.IReqValidator;
import cn.whs.jwt.core.auth.validator.dto.Credence;

/**
 * @author 武海升
 * @version 2.0
 * @description
 *      用于特殊的账号免校验
 * @date 2018-03-17 15:39
 */
public class SpecialValidatorImpl implements IReqValidator {

    private static String USER_NAME = "admin";

    private static String PASSWORD = "root";

    @Override
    public boolean validate(Credence credence) {

        String userName = credence.getCredenceName();
        String password = credence.getCredenceCode();

        if (USER_NAME.equals(userName) && PASSWORD.equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}
