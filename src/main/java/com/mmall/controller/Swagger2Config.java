package com.mmall.controller;

/**
 * @author JS
 * @version 1.0
 * @date 2021/3/21 22:27
 * @description //TODO
 */

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2API文档的配置
 */

@EnableSwagger2 //使swagger2生效
@ComponentScan(basePackages = {"com.mmall.controller"}) //需要扫描的controller包路径
@Configurable //配置注解，自动在本类上下文加载一些环境变量信息
public class Swagger2Config extends WebMvcConfigurationSupport {
    //RestApiConfig
    @Bean
    public Docket buildDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInf())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mmall.controller"))//controller路径
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo buildApiInf(){
        return new ApiInfoBuilder()
                .title("这是我第一次成功使用swagger")
                .termsOfServiceUrl("http://www.baidu.com")
                .description("springmvc swagger2")
                .contact(new Contact("JS",
                        "https://blog.csdn.net/zhang289202241/article/details/78553318",
                        "js@163.com"))
                .build();

    }
}
