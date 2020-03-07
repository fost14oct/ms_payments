package com.homehub.ms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Value("${swagger.allowed}")
    private Boolean swaggerAllowed;


    @Bean
    public Docket sadrApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.homehub.ms.controller"))
                .paths(regex("/.*"))
                .build()
                .apiInfo(apiInfo())
                .enable(swaggerAllowed);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("HomeHub Payments - Microservice.Survey")
                .version("0.0.1-SNAPSHOT")
                .build();
    }
}