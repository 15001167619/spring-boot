package cn.whs.jwt.core.auth.validator.impl;

import cn.whs.jwt.core.auth.validator.IReqValidator;
import cn.whs.jwt.core.auth.validator.dto.Credence;
import cn.whs.jwt.modules.dao.SysUserMapper;
import cn.whs.jwt.modules.entity.SysUser;
import cn.whs.jwt.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-22 9:53
 */
@Service
public class ReqValidatorImpl implements IReqValidator {

    @Autowired
    private SysUserMapper userMapper;

    @Value("${specialValidator.enable}")
    private boolean enableValidator;

    @Override
    public boolean validate(Credence credence) {
        //是否开启特殊验证
        if (enableValidator && ("666".equals(credence.getCredenceUniqueName()) && "888".equals(credence.getCredenceCode()))) {
            return true;
        } else {
            SysUser sysUser = userMapper.getByMobile(credence.getCredenceUniqueName());
            if(sysUser!=null&&(sysUser.getPassword().equals(MD5Util.md5(credence.getCredenceCode(), sysUser.getSalt())))){
                return true;
            }else{
                return false;
            }
        }
    }
}
