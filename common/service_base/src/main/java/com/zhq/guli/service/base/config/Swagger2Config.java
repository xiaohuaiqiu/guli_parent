package com.zhq.guli.service.base.config;

import com.google.common.base.Predicates;
import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 接口文档
 * 使用Swagger
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    /**
     * 前台的api文档
     *
     * @return
     */
    @Bean
    public Docket webApiConfig() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName("前台网站测试文档")
                .apiInfo(webApiInfo())
                .select()
                .paths(Predicates.and(PathSelectors.regex("/api/.*")))
                .build();
        return docket;
    }

    /**
     * 后台的api文档
     *
     * @return
     */
    @Bean
    public Docket adminApiConfig() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName("后台管理测试文档")
                .apiInfo(adminApiInfo())
                .select()
                .paths(Predicates.and(PathSelectors.regex("/admin/.*")))
                .build();
        return docket;
    }

    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("前台网站的Api文档")
                .description("本文档描述了谷粒学院的api接口定义")
                .version("1.0")
                .contact(new Contact("张怀秋", "https://www.hniu.cn", "2305982152@qq.com"))
                .build();
    }

    private ApiInfo adminApiInfo() {
        return new ApiInfoBuilder()
                .title("后台管理系统的Api文档")
                .description("本文档描述了谷粒学院的api接口定义")
                .version("1.0")
                .contact(new Contact("张怀秋", "https://www.hniu.cn", "2305982152@qq.com"))
                .build();
    }
}
