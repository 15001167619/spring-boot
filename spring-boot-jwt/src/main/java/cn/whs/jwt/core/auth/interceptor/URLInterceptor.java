package cn.whs.jwt.core.auth.interceptor;

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
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        String requestMethod = request.getRequestURI();
        if(requestMethod==null)
            return false;
        //
        if (requestMethod.contains("swagger")||requestMethod.contains("/v2/api-docs")) {
            return true;
        }
        if (request.getServletPath().equals("/auth")) {//获取token
            return true;
        }
        if(request.getServletPath().contains("/auth/")){
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
