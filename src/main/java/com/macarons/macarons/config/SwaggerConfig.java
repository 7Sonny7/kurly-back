package com.macarons.macarons.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {

    private static final String API_NAME = "Macarons API";
    private static final String API_VERSION = "0.0.1";
    private static final String API_DESCRIPTION = "Macarons APP을 위한 REST API";

    private String version;
    private String title;

    @Bean
    public Docket apiV1(){
        version = "Banner Image";
        title = "Banner 정보 API";
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages((false))
                .groupName(title)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/macarons/banner/**"))
                .build()
                .apiInfo(apiInfo(title, version));
    }

    public ApiInfo apiInfo(String title, String version){
        return new ApiInfoBuilder()
                .title(API_NAME)
                .version(API_VERSION)
                .description(API_DESCRIPTION)
                .contact(new Contact("Macarons", "https:", "jwpark@hist.co.kr"))
                .build();
    }
}