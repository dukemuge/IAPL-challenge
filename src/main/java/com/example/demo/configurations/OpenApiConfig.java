package com.example.demo.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI().info(new Info().title("Robot-Survor system")
                .description("Robot- Survivor API management system").version("v1.0")
                .contact(new Contact().name("Duke Muge").url("https://dukemugeJava.com").email("dukemuge232@gmail.com"))
                .termsOfService("TOC").license(new License().name("License").url("#")));
    }
}