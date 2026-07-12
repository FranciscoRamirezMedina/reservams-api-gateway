package com.duoc.reservams.apigateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// configuracion de rutas del API Gateway
@Configuration
public class GatewayRoutesConfig {

    @Value("${services.auth-url}")
    private String authServiceUrl;

    @Value("${services.user-url}")
    private String userServiceUrl;

    @Value("${services.hotel-url}")
    private String hotelServiceUrl;

    @Value("${services.room-url}")
    private String roomServiceUrl;

    @Value("${services.availability-url}")
    private String availabilityServiceUrl;

    @Value("${services.reservation-url}")
    private String reservationServiceUrl;

    @Value("${services.payment-url}")
    private String paymentServiceUrl;

    @Value("${services.notification-url}")
    private String notificationServiceUrl;

    @Value("${services.review-url}")
    private String reviewServiceUrl;

    @Value("${services.report-url}")
    private String reportServiceUrl;

    @Bean
    public RouteLocator customRoutes(RouteLocatorBuilder builder) {
        return builder.routes()

                // Ruta hacia auth-service
                .route("auth-service", route -> route
                        .path("/api/v1/auth/**")
                        .uri(authServiceUrl))

                // Ruta hacia user-service
                .route("user-service", route -> route
                        .path("/api/v1/users/**")
                        .uri(userServiceUrl))

                // Ruta hacia hotel-service
                .route("hotel-service", route -> route
                        .path("/api/v1/hotels/**")
                        .uri(hotelServiceUrl))

                // Ruta hacia room-service
                .route("room-service", route -> route
                        .path("/api/v1/rooms/**")
                        .uri(roomServiceUrl))

                // Ruta hacia availability-service
                .route("availability-service", route -> route
                        .path("/api/v1/availability/**")
                        .uri(availabilityServiceUrl))

                // Ruta hacia reservation-service
                .route("reservation-service", route -> route
                        .path("/api/v1/reservations/**")
                        .uri(reservationServiceUrl))

                // Ruta hacia payment-service
                .route("payment-service", route -> route
                        .path("/api/v1/payments/**")
                        .uri(paymentServiceUrl))

                // Ruta hacia notification-service
                .route("notification-service", route -> route
                        .path("/api/v1/notifications/**")
                        .uri(notificationServiceUrl))

                // Ruta hacia review-service
                .route("review-service", route -> route
                        .path("/api/v1/reviews/**")
                        .uri(reviewServiceUrl))

                // Ruta hacia report-service
                .route("report-service", route -> route
                        .path("/api/v1/reports/**")
                        .uri(reportServiceUrl))

                .build();
    }
}