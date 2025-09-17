package com.api.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRoutesConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("quizservice", r -> r
                        .path("/quiz/**")
                        .uri("lb://quizservice"))
                .route("questionservice", r -> r
                        .path("/questions/**")
                        .uri("lb://questionservice"))
                .build();
    }
}
