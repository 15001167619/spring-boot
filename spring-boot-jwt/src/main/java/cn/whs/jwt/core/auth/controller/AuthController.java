package cn.whs.jwt.core.auth.controller;

import cn.whs.jwt.core.auth.controller.dto.AuthRequestImpl;
import cn.whs.jwt.core.auth.controller.dto.AuthResponseImpl;
import cn.whs.jwt.core.auth.util.JwtTokenUtil;
import cn.whs.jwt.core.auth.validator.IReqValidator;
import cn.whs.jwt.core.exception.ExceptionEnum;
import cn.whs.jwt.core.exception.TipsRuntimeException;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @Resource(name = "specialValidatorImpl")
    private IReqValidator reqValidator;

    /**
     * 获取用户列表
     */
    @ApiOperation(value="获取 Token", notes="获取 Token")
    @RequestMapping(value = "${jwt.auth-path}", method= RequestMethod.GET)
    public ResponseEntity<?> createAuthenticationToken(AuthRequestImpl authRequest) {

        boolean validate = reqValidator.validate(authRequest);

        if (validate) {
            final String randomKey = jwtTokenUtil.getRandomKey();
            final String token = jwtTokenUtil.generateToken(authRequest.getUserName(), randomKey);
            return ResponseEntity.ok(new AuthResponseImpl(token, randomKey));
        } else {
            throw new TipsRuntimeException(ExceptionEnum.AUTH_REQUEST_ERROR);
        }
    }

}
