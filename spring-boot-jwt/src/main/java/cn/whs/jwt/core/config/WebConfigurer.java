package cn.whs.jwt.core.config;

import cn.whs.jwt.core.auth.interceptor.URLInterceptor;
import cn.whs.jwt.core.config.properties.RestProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-21 10:17
 */
@Configuration
public class WebConfigurer  extends WebMvcConfigurerAdapter {

    @Bean   //拦截器注入为bean
    @ConditionalOnProperty(prefix = RestProperties.REST_PREFIX, name = "auth-open", havingValue = "true", matchIfMissing = true)
    public HandlerInterceptor getMyInterceptor(){
        return new URLInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则, 拦截 /url 后面的全部链接
        // excludePathPatterns swagger 不拦截  排除拦截
        registry.addInterceptor(getMyInterceptor()).addPathPatterns("/auth","/auth/","/**/auth/**").excludePathPatterns("/");
        super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
