package pet.project.gatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    private final static String AUTH_SERVICE_ROUTE_ID = "auth_service_route_id";
    private final static String AUTH_SERVICE_PREFIX = "api/auth";
    private final static String AUTH_SERVICE_URI = "http://localhost:8081";

    private final static String USER_SERVICE_ROUTE_ID = "user_service_route_id";
    private final static String USER_SERVICE_PREFIX = "api/users";
    private final static String USER_SERVICE_URI = "http://localhost:8082";

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(AUTH_SERVICE_ROUTE_ID, r -> r.path(AUTH_SERVICE_PREFIX + "/**")
                        .filters(f -> f.stripPrefix(2))
                        .uri(AUTH_SERVICE_URI))
                .route(USER_SERVICE_ROUTE_ID, r -> r.path(USER_SERVICE_PREFIX + "/**")
                        .filters(f -> f.stripPrefix(2))
                        .uri(USER_SERVICE_URI))
                .build();
    }
}
