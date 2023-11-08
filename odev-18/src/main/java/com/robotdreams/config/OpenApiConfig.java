package com.robotdreams.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* http://localhost:8080/swagger-ui/index.html#/*/

@OpenAPIDefinition
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI baseOpenAPI(){
        Components components = new Components();
        return new OpenAPI().components(components)
                .info(new Info()
                        .title("TodoList Spring Boot Project OpenAPI Docs")
                        .version("1.0.0")
                        .description("Doc Description")
                        .title("Sadik Algul APIs"));
    }

}