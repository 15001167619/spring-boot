package cn.whs.jwt.core.auth.controller;

import cn.whs.jwt.core.auth.util.JwtTokenUtil;
import cn.whs.jwt.core.auth.validator.IReqValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 武海升
 * @version 2.0
 * @description
 *      请求验证的
 * @date 2018-03-17 15:44
 */
@RestController
public class AuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

}
