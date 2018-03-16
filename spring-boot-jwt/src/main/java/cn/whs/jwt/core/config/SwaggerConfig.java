package cn.whs.jwt.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * http://localhost:6080/swagger-ui.html
 *  Swagger2默认将所有的Controller中的RequestMapping方法都会暴露，
 * @ApiIgnore 来解决，如果应用在Controller范围上，则当前Controller中的所有方法都会被忽略，
 *  如果应用在方法上，则对应用的方法忽略暴露API
 * @date 2018-03-16 10:32
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.whs.jwt.modules.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("Swagger API 接口文档")
                .contact("程序猿")
                .version("1.0")
                .build();
    }
}
