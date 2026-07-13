package com.duoc.reservams.apigateway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.gateway.route.RouteLocator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ReservamsApiGatewayApplicationTests {

	@Autowired
	private RouteLocator routeLocator;

	@Value("${spring.application.name}")
	private String applicationName;

	@Value("${server.port}")
	private int serverPort;

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

	@Test
	void contextLoads() {
		assertNotNull(routeLocator);
	}

	@Test
	void shouldLoadGatewayBaseConfiguration() {
		assertEquals("reservams-api-gateway", applicationName);
		assertEquals(8080, serverPort);
	}

	@Test
	void shouldLoadServiceUrlsForRoutes() {
		assertEquals("http://localhost:8081", authServiceUrl);
		assertEquals("http://localhost:8082", userServiceUrl);
		assertEquals("http://localhost:8083", hotelServiceUrl);
		assertEquals("http://localhost:8084", roomServiceUrl);
		assertEquals("http://localhost:8085", availabilityServiceUrl);
		assertEquals("http://localhost:8086", reservationServiceUrl);
		assertEquals("http://localhost:8087", paymentServiceUrl);
		assertEquals("http://localhost:8088", notificationServiceUrl);
		assertEquals("http://localhost:8089", reviewServiceUrl);
		assertEquals("http://localhost:8090", reportServiceUrl);
	}
}