package com.codigo.jose_rodriguez_hexagonal.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Configuration
public class SwaggerConfig {
    @Autowired
    private OpenApiProperties openApiProperties;
    @Bean
    public OpenAPI customOpenApi() {
        Info info = new Info();
        info.setTitle(openApiProperties.getTitle());
        info.setVersion(openApiProperties.getVersion());
        info.setDescription(openApiProperties.getDescription());
        OpenAPI openApi =  new OpenAPI().info(info);
        Supplier<List<Server>> servers = () ->
                Optional.ofNullable(openApiProperties.getServers())
                        .map(x -> x.stream()
                                .map(s -> new Server().url(s))
                                .collect(Collectors.toList())
                        ).orElse(new ArrayList<>());
        openApi.servers(servers.get());
        return openApi;
    }
}
