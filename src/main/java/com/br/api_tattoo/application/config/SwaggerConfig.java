package com.br.api_tattoo.application.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI(SwaggerUiConfigProperties swaggerUiConfigProperties) {
        Map<String, Object> extensions = new HashMap<>();
        extensions.put("showExtensions", swaggerUiConfigProperties.getShowExtensions());

        return new OpenAPI()
                .info(new Info().title("Serviço para gerenciamento de estúdio de tatuagem")
                        .description("API para gerenciar produtos e serviços de um estúdio de tatuagem")
                        .version("1.0.0"))
                .addServersItem(new Server().url("http://localhost:8080").description("Ambiente Local"))
                .components(new io.swagger.v3.oas.models.Components())
                .extensions(extensions);
    }
}