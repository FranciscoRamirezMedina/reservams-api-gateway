package com.duoc.reservams.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// configuracion de rutas del API Gateway
@Configuration
public class GatewayRoutesConfig {

    @Bean
    public RouteLocator customRoutes(RouteLocatorBuilder builder) {
        return builder.routes()

                //ruta hacia auth-server
                // toda peticion /api/v1/auth/** se enviara al auth-service
                .route("auth-service", route -> route
                        .path("/api/v1/auth/**")
                        .uri("http://localhost:8081"))

                //ruta hacia user-service
                .route("user-service", route -> route
                        .path("/api/v1/users/**")
                        .uri("http://localhost:8082"))

                // Ruta hacia hotel-service
                .route("hotel-service", route -> route
                        .path("/api/v1/hotels/**")
                        .uri("http://localhost:8083"))

                // Ruta hacia room-service
                .route("room-service", route -> route
                        .path("/api/v1/rooms/**")
                        .uri("http://localhost:8084"))

                .build();

    }
}