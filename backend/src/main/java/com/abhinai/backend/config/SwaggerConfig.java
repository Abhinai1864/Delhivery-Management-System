package com.abhinai.backend.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI deliveryManagementOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Delivery Management System API")
                        .description("REST API for managing shipments")
                        .version("1.0"))
                .externalDocs(new ExternalDocumentation()
                        .description("Project Documentation"));
    }
}