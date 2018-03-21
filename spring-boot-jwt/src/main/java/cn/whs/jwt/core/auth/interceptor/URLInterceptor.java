package cn.whs.jwt.core.auth.interceptor;

import cn.whs.jwt.core.ErrorPrompt;
import cn.whs.jwt.core.auth.util.JwtTokenUtil;
import cn.whs.jwt.core.exception.ExceptionEnum;
import cn.whs.jwt.utils.CommonUtils;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-21 11:07
 */
public class URLInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        String requestMethod = request.getRequestURI();
        if(requestMethod==null)
            return false;
        //过滤swagger
        if (requestMethod.contains("swagger")||requestMethod.contains("/v2/api-docs")) {
            return true;
        }
        if (request.getServletPath().equals("/auth")) {//获取token
            return true;
        }
        if(request.getServletPath().contains("/auth/")){

            String authToken = request.getParameter("authToken");
            //验证token是否过期,包含了验证jwt是否正确
            try {
                boolean flag = jwtTokenUtil.isTokenExpired(authToken);
                if (flag) {
                    CommonUtils.renderJson(response, new ErrorPrompt(ExceptionEnum.TOKEN_EXPIRED.getCode(), ExceptionEnum.TOKEN_EXPIRED.getMessage()));
                    return false;
                }
            } catch (JwtException e) {
                //有异常就是token解析失败
                CommonUtils.renderJson(response, new ErrorPrompt(ExceptionEnum.TOKEN_ERROR.getCode(), ExceptionEnum.TOKEN_ERROR.getMessage()));
                return false;
            }
            return true;
        }
        return false;
    }

    private boolean checkRequestMethod(String requestMethod) {
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
