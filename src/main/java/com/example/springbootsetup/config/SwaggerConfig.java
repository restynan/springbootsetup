package com.example.springbootsetup.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
public class SwaggerConfig {
        @Bean
        public Docket api() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.example.springbootsetup"))
                    .paths(regex("/api.*"))
                    .build()
                    .apiInfo(metaInfo());
        }
    private ApiInfo metaInfo() {
            return  new ApiInfoBuilder()
                    .title("Spring Boot Swagger Example API")
                    .description("Spring Boot Swagger Example for springbootsetup")
                    .license("Apache License Version 2.0")
                    .contact(new Contact("Resty Nasimbwa","https://www.ford.com/","rnasimbw@ford.com"))
                    .build();


       }

    }
