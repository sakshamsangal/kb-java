package com.example.swagger;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.security.*;
import org.springframework.context.annotation.*;


@Configuration
public class Config {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().components(new Components()
                .addSecuritySchemes("bearer-key",
                        new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));
    }
}
