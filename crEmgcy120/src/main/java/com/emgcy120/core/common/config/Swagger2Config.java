package com.emgcy120.core.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
	
    @Bean
    public Docket sysApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("系统")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.emgcy120.core.system.sys"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket orgApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("医院／单位／科室")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.emgcy120.core.system.org"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket eventApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("事件")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.emgcy120.core.system.event"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket callApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("通话")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.emgcy120.core.system.call"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("更多Swagger2相关文章请关注：https://swagger.io/docs/specification/what-is-swagger/")
                .termsOfServiceUrl("https://swagger.io/docs/specification/what-is-swagger/")
                .contact("crEmgcy120")
                .version("1.0")
                .build();
    }

}
